package io.datajek.spring.basics.movierecommendersystem.lesson10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.datajek.spring.basics.movierecommendersystem.lesson1.Filter;

@Component
@Primary
@Qualifier("CBF")
@Scope("prototype")
public class CollaborativeBasedFilter implements Filter {

	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	  public String[] getRecommendations(String movie) {
	        //logic of Collaborative based filter
	        return new String[] {};
	    }
}
