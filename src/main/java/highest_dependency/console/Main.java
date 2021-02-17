package highest_dependency.console;

import highest_dependency.algorithm.Dependency;
import highest_dependency.algorithm.DependencyGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        // input number
        int count = -1;

        // list of output numbers
        List<Integer> outputs = new ArrayList<>();

        while (true){
            // input check*******
            count = scanner.nextInt();
            if (count == 0)
                break;

            // fix buffer
            scanner.nextLine();
            //******************

            DependencyGraph<Integer> dependencyGraph = new DependencyGraph<>();
            List<Dependency<Integer>> dependencies = new ArrayList<>();

            for (int i = 0; i < count; i++)
                dependencies.add(new Dependency<Integer>(i));

            for (int i = 0; i < count; i++){
                String line = scanner.nextLine();

                String[] numbs = line.split(" ");
                for (int j = 1; j < numbs.length; j++){
                    dependencies.get(i).addChildDependency(dependencies.get(j));
                }
                dependencyGraph.addDependency(dependencies.get(i));
            }

            int num = 0;
            int index = 0;
            for (Dependency<Integer> dependency: dependencyGraph.getDependencies()){
                int size = dependencyGraph.getAllDependenciesFrom(dependency).size();
                if (num < size){
                    num = size;
                    index = dependencies.indexOf(dependency)+1;
                }

            }

            outputs.add(index);
        }

        for (Integer num: outputs)
            System.out.println(num);
    }
}
