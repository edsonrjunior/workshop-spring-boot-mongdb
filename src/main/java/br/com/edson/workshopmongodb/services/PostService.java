package br.com.edson.workshopmongodb.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edson.workshopmongodb.domain.Post;
import br.com.edson.workshopmongodb.repository.PostRepository;
import br.com.edson.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
//	ou	return repo.findByTitleContainingIgnoreCase(text);
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		//Add 24 horas no maxDate
		maxDate = new Date(maxDate.getTime() + 24 * 60 *  1000);		
		return repo.fullSearch(text, minDate, maxDate);
	}
	

}
