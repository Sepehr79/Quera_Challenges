package highest_dependency;

import highest_dependency.algorithm.Dependency;
import highest_dependency.algorithm.DependencyGraph;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class UnitTest {

    @Test
    public void testDependency(){
        Dependency<String> dependency1 = new Dependency<>("1");
        Dependency<String> dependency2 = new Dependency<>("2");

        dependency1.addChildDependency(dependency2);

        Assert.assertEquals(dependency1.getChildDependencies().size(), 1);
    }

    @Test
    public void testEquation(){
        Dependency<String> dependency1 = new Dependency<>("1");
        Dependency<String> dependency2 = new Dependency<>("1");

        Assert.assertEquals(dependency1, dependency2);
    }

    @Test
    public void testDependencyGraph(){
        Dependency<String> dependency1 = new Dependency<>("1");
        Dependency<String> dependency2 = new Dependency<>("2");
        Dependency<String> dependency3 = new Dependency<>("3");

        dependency2.addChildDependency(dependency1);
        dependency2.addChildDependency(dependency3);

        DependencyGraph<String> dependencyGraph = new DependencyGraph<>();
        dependencyGraph.addDependencies(dependency1, dependency2, dependency3);

        Assert.assertEquals(dependencyGraph.getDependencies().size(), 3);
        Assert.assertEquals(dependency2.getChildDependencies().size(), 2);

        Dependency<String> another1 = new Dependency<>("another1");
        Dependency<String> another2 = new Dependency<>("another2");

        dependency1.addChildDependency(another1);
        dependency1.addChildDependency(another2);

        Set<Dependency<String>> dependencies = dependencyGraph.getAllDependenciesFrom(dependency2);

        Assert.assertEquals(dependencies.size(), 4);
    }

    @Test
    public void testDependencyAdding(){
        Dependency<String> dependency1 = new Dependency<>("1");
        Dependency<String> dependency2 = new Dependency<>("2");
        Dependency<String> dependency3 = new Dependency<>("3");
        Dependency<String> dependency4 = new Dependency<>("4");
        Dependency<String> dependency5 = new Dependency<>("5");
        Dependency<String> dependency6 = new Dependency<>("6");
        Dependency<String> dependency7 = new Dependency<>("7");
        Dependency<String> dependency8 = new Dependency<>("8");

        dependency4.addChildDependency(dependency1);
        dependency4.addChildDependency(dependency2);
        dependency4.addChildDependency(dependency3);
        dependency4.addChildDependency(dependency5);

        dependency1.addChildDependency(dependency2);
        dependency1.addChildDependency(dependency3);
        dependency3.addChildDependency(dependency5);

        DependencyGraph<String> dependencyGraph = new DependencyGraph<>();
        dependencyGraph.addDependencies(dependency1, dependency2, dependency3, dependency4, dependency5, dependency6,
                dependency7, dependency8);

        Set<Dependency<String>> dependencies = dependencyGraph.getAllDependenciesFrom(dependency4);
        Assert.assertEquals(dependencies.size(), 4);

        dependency5.addChildDependency(dependency8);

        dependencies = dependencyGraph.getAllDependenciesFrom(dependency4);
        Assert.assertEquals(dependencies.size(), 5);

        dependency8.addChildDependency(dependency7);

        dependencies = dependencyGraph.getAllDependenciesFrom(dependency4);
        Assert.assertEquals(dependencies.size(), 6);

        dependencies = dependencyGraph.getAllDependenciesFrom(dependency8);
        Assert.assertEquals(dependencies.size(), 1);
    }
}
