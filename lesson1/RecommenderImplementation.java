package io.datajek.spring.basics.movierecommendersystem.lesson1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class RecommenderImplementation {

	// use filter interface to select filter
	@Autowired
	private Filter filter;
	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());


	 
		public RecommenderImplementation(Filter filter) {
			this.filter = filter;
		}
	 
	public String[] recommendMovies(String movie) {

		
		
		// print the name of interface implementation being used
		System.out.println("Name of the filter in use: " + filter + "\n");

		String[] results = filter.getRecommendations(movie);
		// return the results
		return results;
	}
	
	@PostConstruct
    public void postConstruct() {
        //initialization code goes here
        logger.info("In RecommenderImplementation postConstruct method");
    }
	
	@PreDestroy
	 public void preDestroy() {
        //cleanup code
        logger.info("In RecommenderImplementation preDestroy method");
    }
}
