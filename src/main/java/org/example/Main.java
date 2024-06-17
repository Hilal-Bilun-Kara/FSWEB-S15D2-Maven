package org.example;

import org.example.entity.*;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


        Set<Task> annsTasks =  new HashSet<>();
        Task taskAnn = new Task("workintech","dummy desc4","ann", Priority.LOW, Status.ASSIGNED);
        Task taskAnn2 = new Task("workintech","dummy desc 1","ann", Priority.LOW, Status.ASSIGNED);
        annsTasks.add(taskAnn);
        annsTasks.add(taskAnn2);

        Set<Task> bobsTasks =  new HashSet<>();
        Task taskBob = new Task("workintech","dummy desc5","bob", Priority.HIGH, Status.IN_PROGRESS);
        Task taskBob2 = new Task("workintech","dummy desc 2","bob", Priority.HIGH, Status.ASSIGNED);
        bobsTasks.add(taskBob);
        bobsTasks.add(taskBob2);

        Set<Task> carolsTasks =  new HashSet<>();
        Task taskCarol = new Task("workintech","dummy desc3","carol", Priority.HIGH, Status.IN_PROGRESS);
        Task taskCarol2 = new Task("workintech","dummy desc 2","carol", Priority.HIGH, Status.ASSIGNED);
        carolsTasks.add(taskCarol);
        carolsTasks.add(taskCarol2);


        Set<Task> unassignedTasks =  new HashSet<>();
        Task taskUnassigned = new Task("workintech","dummy desc 6",null, Priority.HIGH, Status.IN_PROGRESS);
        unassignedTasks.add(taskUnassigned);
        TaskData taskData = new TaskData(annsTasks,bobsTasks,carolsTasks,unassignedTasks);
        System.out.println("bobTasks:" + taskData.getTasks("bob"));
        System.out.println("carolTasks:" + taskData.getTasks("carol"));
        System.out.println("allTasks:" + taskData.getTasks("all"));

        System.out.println("unassigned:" + taskData.getDifferences(unassignedTasks,taskData.getTasks("ann")));

        // Görev listelerini diziye koyma
        Set<Task>[] taskSets = new Set[]{annsTasks, bobsTasks, carolsTasks};

        // Dinamik karşılaştırma
        for (int i = 0; i < taskSets.length; i++) {
            for (int j = i + 1; j < taskSets.length; j++) {
                Set<Task> intersection = taskData.getIntersection(taskSets[i], taskSets[j]);
                System.out.println("Difference between list " + (i+1) + " and list " + (j+1) + ": " + intersection);
            }
        }

        StringSet.findUniqueWords();
    }
}