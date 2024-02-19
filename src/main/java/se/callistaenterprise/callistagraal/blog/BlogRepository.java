package se.callistaenterprise.callistagraal.blog;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends CrudRepository<BlogEntity,Long> {
}
