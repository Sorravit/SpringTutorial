#!/bin/bash
REDIS_DOCKER_NAME="spring-tutorial-redis"
DATABASE_DOCKER_NAME="spring-tutorial-mysql"

goal_database_start() {
  docker run --detach --env MYSQL_ROOT_PASSWORD=sorravit --env MYSQL_USER=sorravit --env MYSQL_PASSWORD=sorravit --env MYSQL_DATABASE=big --name ${DATABASE_DOCKER_NAME} --publish 3302:3306 mysql
}
goal_database_stop() {
  docker stop ${DATABASE_DOCKER_NAME}
}
goal_database_migrate() {
  ./gradlew flywayMigrate
}
goal_redis_start() {
  docker run -d --rm --name ${REDIS_DOCKER_NAME} -e "ALLOW_EMPTY_PASSWORD=false" -e "REDIS_PASSWORD=Password123" -p6379:6379 bitnami/redis
}
goal_redis_stop() {
  docker kill ${REDIS_DOCKER_NAME}
}
goal_start_dev_env() {
  goal_database_start
  goal_redis_start
}
goal_stop_dev_env() {
  goal_database_stop
  goal_redis_stop
}

if type -t "goal_$1" &>/dev/null; then
  goal_$1 ${@:-2}
else
  echo "usage: $0 <goal>
    goal:
        start_dev_env                       -- start development environment
        stop_dev_env                        -- stop development environment
        database_start                      -- start database from mysql docker image
        database_stop                       -- stop database from mysql docker image
        database_migrate                    -- migrate database using flyway migration
        redis_start                         -- start redis from redis docker image
        redis_stop                          -- stop redis docker
        "
  exit 1
fi
