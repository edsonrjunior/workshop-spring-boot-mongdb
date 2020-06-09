package br.com.edson.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.edson.workshopmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
}
