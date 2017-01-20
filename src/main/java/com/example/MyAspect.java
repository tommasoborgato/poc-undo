package com.example;

import com.example.jpa.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by icttb0 on 20/01/2017.
 */
@Aspect
@Component
public class MyAspect {

    @Autowired
    private NodeBkpRepository nodeBkpRepository;
    @Autowired
    private TrailBkpRepository trailBkpRepository;
    private DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    public MyAspect(
    ) {
        System.out.println("=================== MyAspect ============================");
    }

    @AfterReturning("execution(* com.example.jpa.NodeRepository.*save*(..)) or execution(* com.example.jpa.NodeRepository.*delete*(..))")
    private void logNode(JoinPoint joinPoint){
        System.out.println("=================== MyAspect.logNode " + joinPoint.getSignature() + " ============================");
        for (Object node : joinPoint.getArgs()) {
            System.out.println(node);
            if (node instanceof Node){
                NodeBkp nodeBkp = dozerBeanMapper.map(node, NodeBkp.class);
                nodeBkpRepository.save(nodeBkp);
            }
        }
    }

    @AfterReturning("execution(* com.example.jpa.TrailRepository.*save*(..)) or execution(* com.example.jpa.TrailRepository.*delete*(..))")
    private void logTrail(JoinPoint joinPoint){
        System.out.println("=================== MyAspect.logTrail " + joinPoint.getSignature() + " ============================");
        for (Object trail : joinPoint.getArgs()) {
            System.out.println(trail);
            if (trail instanceof Trail){
                TrailBkp trailBkp = dozerBeanMapper.map(trail,TrailBkp.class);
                trailBkpRepository.save(trailBkp);
            }
        }
    }
}
