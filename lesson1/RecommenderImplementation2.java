package io.datajek.spring.basics.movierecommendersystem.lesson1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation2 {

	// use filter interface to select filter
	
	
	private Filter filter;

	



	
	@Autowired
	public void setFilter(Filter filter) {
	    this.filter = filter;
	    System.out.println("Setter method invoked..");
	}
	
	public String[] recommendMovies(String movie) {

		// print the name of interface implementation being used
		System.out.println("Name of the filter in use: " + filter + "\n");

		String[] results = filter.getRecommendations(movie);
		// return the results
		return results;
	}
}
