package io.datajek.spring.basics.movierecommendersystem.lesson1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import io.datajek.spring.basics.movierecommendersystem.lesson8.Movie;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
@Qualifier("CF")
public class ContentBasedFilter implements Filter {

	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//for keeping track of instances created
    private static int instances= 0;
	
    
    @Autowired
    private Movie movie;

    public ContentBasedFilter() {
        instances++;      
        System.out.println("ContentBasedFilter constructor called");
    }
    
	  public String[] getRecommendations(String movie) {
	        //logic of content based filter
	        return new String[] {"Happy Feet", "Ice Age", "Shark Tale"};
	    }
	  
	  public Movie getMovie() {
	        return movie;
	    }

	    public static int getInstances(){
	        return ContentBasedFilter.instances;
	    }
	    
	    @PostConstruct
	    private void postConstruct() {
	        //load movies into cache
	        logger.info("In ContentBasedFilter postConstruct method");
	    }
	    
	    @PreDestroy
	    private void preDestroy() {
	        //clear movies from cache
	        logger.info("In ContentBasedFilter preDestroy method");
	    }
	 
}
