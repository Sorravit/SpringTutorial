package sorravit.springtutorial.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import sorravit.springtutorial.model.Product;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("SELECT * FROM product")
    List<Product> findAll();

    @Select("SELECT * FROM product WHERE id = #{id}")
    Product findById(@Param("id") Long id);

    @Insert("INSERT INTO product(name, price) VALUES(#{name}, #{price})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Product product);

    @Update("UPDATE product SET name = #{name}, price = #{price} WHERE id = #{id}")
    void update(Product product);

    @Delete("DELETE FROM product WHERE id = #{id}")
    void delete(@Param("id") Long id);
}
