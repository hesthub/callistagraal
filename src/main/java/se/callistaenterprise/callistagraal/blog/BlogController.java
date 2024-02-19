package se.callistaenterprise.callistagraal.blog;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

  @Autowired
  DataSource dataSource;

  private final BlogRepository blogRepository;

  public BlogController(BlogRepository blogRepository) {
    this.blogRepository = blogRepository;
  }

  @GetMapping
  List<BlogEntity> getBlogs() {
    return (List<BlogEntity>) blogRepository.findAll();
  }

  @PostMapping
  void setupBlogs() throws SQLException {
    BlogEntity blog1 = new BlogEntity("en blogg", "Lorem");
    BlogEntity blog2 = new BlogEntity("två blogg", "Ipsum");

    Connection conn = dataSource.getConnection();
    conn.createStatement().execute("CREATE TABLE blogs(id SERIAL PRIMARY KEY, name VARCHAR(100), content VARCHAR(100))");

    blogRepository.save(blog1);
    blogRepository.save(blog2);
  }
}
