package com.example;

import com.example.jpa.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;

@SpringBootApplication
@EnableAspectJAutoProxy
public class PocUndoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new PocUndoApplication()
                .configure(new SpringApplicationBuilder(PocUndoApplication.class))
                .run(args);
    }

    @Bean
    CommandLineRunner runner(
            NodeRepository nr,
            TrailRepository tr,
            NodeBkpRepository nbr,
            TrailBkpRepository tbr
    ) {
        return args -> {
            Arrays.asList("node1,node2,node3,node4,node5,node6".split(",")).forEach(n -> nr.save(new Node(n)));
            System.out.println("=================== FIND ALL =============================");
            nr.findAll().forEach(System.out::println);
            nr.findAll().forEach(n->{n.setName("NEWNAME "+n.getName());nr.save(n);});

            Arrays.asList("trail1,trail2,trail3,trail4,trail5,trail6".split(",")).forEach(n -> tr.save(new Trail(n)));
            System.out.println("=================== FIND ALL =============================");
            tr.findAll().forEach(System.out::println);

            System.out.println("=================== FIND ALL =============================");
            nbr.findAll().forEach(System.out::println);

            System.out.println("=================== FIND ALL =============================");
            tbr.findAll().forEach(System.out::println);
        };
    }
}


