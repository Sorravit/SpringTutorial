goal_hello(){
    echo "Hello, from the other side!"
}
if type -t "goal_$1" &>/dev/null; then
  goal_$1 ${@:-2}
else
    echo "usage: $0 <goal>
    goal:
        hello                     -- say hello back so the programmer is not lonely
        "
  exit 1
fi
