package com.example;

import com.example.jpa.maindb.Node;
import com.example.jpa.undodb.NodeBkpRepository;
import com.example.jpa.undodb.TrailBkpRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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

    /**
     * INSERT
     * @param joinPoint
     */
    @Before("execution(* javax.persistence.EntityManager.persist(..))")
    private void logNodePersist(JoinPoint joinPoint){
        for (Object node : joinPoint.getArgs()) {
            if (node instanceof Node) {
                System.out.println("=================== " + joinPoint.getSignature() + " ============================");
                if (((Node) node).getId()==null){
                    System.out.println(joinPoint.getSignature() + " ::INSERT:: " + node);

                    //TODO: salvare l'ID dell'entity perche' per tornare indietro va fatta delete
                }else{
                    System.out.println(joinPoint.getSignature() + " ::UPDATE:: " + node);
                }
            }
        }
    }

    /**
     * UPDATE
     * @param joinPoint
     */
    @Before("execution(* javax.persistence.EntityManager.merge(..))")
    private void logNodeMerge(JoinPoint joinPoint){
        for (Object node : joinPoint.getArgs()) {
            if (node instanceof Node) {
                System.out.println("=================== " + joinPoint.getSignature() + " ============================");
                if (((Node) node).getId()==null){
                    System.out.println(joinPoint.getSignature() + " ::INSERT:: " + node);
                }else{
                    System.out.println(joinPoint.getSignature() + " ::UPDATE:: " + node);

                    //TODO: recuperare da DB l'entity prima dell'Update perchè per tornare indietro occorre fare l'update coi valori porecendenti
                }
            }
        }
    }

    @Before("execution(* javax.persistence.EntityManager.find(..))")
    private void logNodeFind(JoinPoint joinPoint){
        System.out.println("=================== " + joinPoint.getSignature() + " ============================");

    }

    @Before("execution(* javax.persistence.EntityManager.remove(..))")
    private void logNodeRemove(JoinPoint joinPoint){
        System.out.println("=================== " + joinPoint.getSignature() + " ============================");

    }

/*
    @Before("execution(* com.example.jpa.maindb.NodeRepository.*save*(..))")
    private void logNodeSaveBefore(JoinPoint joinPoint){
        System.out.println("=================== MyAspect.logNodeSave " + joinPoint.getSignature() + " ============================");
        for (Object node : joinPoint.getArgs()) {
            if (node instanceof Node){
                if (((Node) node).getId()==null){
                    System.out.println(joinPoint.getSignature() + " ::INSERT:: " + node);
                }else{
                    System.out.println(joinPoint.getSignature() + " ::UPDATE:: " + node);
                }
                NodeBkp nodeBkp = dozerBeanMapper.map(node, NodeBkp.class);
                nodeBkpRepository.save(nodeBkp);
            }
        }
    }
*/

/*
    @After("execution(* com.example.jpa.maindb.NodeRepository.*save*(..))")
    private void logNodeSaveAfter(JoinPoint joinPoint){
        System.out.println("=================== MyAspect.logNodeSave " + joinPoint.getSignature() + " ============================");
        for (Object node : joinPoint.getArgs()) {
            if (node instanceof Node){
                if (((Node) node).getId()==null){
                    System.out.println(joinPoint.getSignature() + " ::INSERT:: " + node);
                }else{
                    System.out.println(joinPoint.getSignature() + " ::UPDATE:: " + node);
                }
                NodeBkp nodeBkp = dozerBeanMapper.map(node, NodeBkp.class);
                nodeBkpRepository.save(nodeBkp);
            }
        }
    }
*/

/*
    @Before("execution(* com.example.jpa.maindb.NodeRepository.*delete*(..))")
    private void logNodeDelete(JoinPoint joinPoint){
        System.out.println("=================== MyAspect.logNodeDelete " + joinPoint.getSignature() + " ============================");
        for (Object node : joinPoint.getArgs()) {
            if (node instanceof Node){
                System.out.println(joinPoint.getSignature() + " :: " + node);
                NodeBkp nodeBkp = dozerBeanMapper.map(node, NodeBkp.class);
                nodeBkpRepository.save(nodeBkp);
            }
        }
    }

    @Before("execution(* com.example.jpa.maindb.TrailRepository.*save*(..))")
    private void logTrailSave(JoinPoint joinPoint){
        System.out.println("=================== MyAspect.logTrailSave " + joinPoint.getSignature() + " ============================");
        for (Object trail : joinPoint.getArgs()) {
            if (trail instanceof Trail){
                System.out.println(joinPoint.getSignature() + " :: " + trail);
                TrailBkp trailBkp = dozerBeanMapper.map(trail,TrailBkp.class);
                trailBkpRepository.save(trailBkp);
            }
        }
    }

    @Before("execution(* com.example.jpa.maindb.TrailRepository.*delete*(..))")
    private void logTrailDelete(JoinPoint joinPoint){
        System.out.println("=================== MyAspect.logTrailDelete " + joinPoint.getSignature() + " ============================");
        for (Object trail : joinPoint.getArgs()) {
            if (trail instanceof Trail){
                System.out.println(joinPoint.getSignature() + " :: " + trail);
                TrailBkp trailBkp = dozerBeanMapper.map(trail,TrailBkp.class);
                trailBkpRepository.save(trailBkp);
            }
        }
    }
*/
}
