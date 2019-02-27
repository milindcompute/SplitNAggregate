package com.example.JavaFileCopier;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

@Component
public class MyRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:start").split(body(),new MyAggregationStrategy()).process(new Processor() {
			
			public void process(Exchange exchange) throws Exception {
					System.out.println(exchange.getIn().getBody()+" "+Thread.currentThread().getId());
				
			}
		});
	}
}
