package highest_dependency.algorithm;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
public class DependencyGraph<DT> {

    private final Set<Dependency<DT>> dependencies = new HashSet<>();

    public boolean addDependency(Dependency<DT> dtDependency){
        return dependencies.add(dtDependency);
    }

    @SafeVarargs
    public final void addDependencies(Dependency<DT>... dependencies){
        this.dependencies.addAll(Arrays.asList(dependencies));
    }

    public Set<Dependency<DT>> getAllDependenciesFrom(Dependency<DT> dtDependency){
        Set<Dependency<DT>> visited = new HashSet<>(dtDependency.getChildDependencies());
        Set<Dependency<DT>> set = new HashSet<>(dtDependency.getChildDependencies());

        while (!set.isEmpty()){
            Set<Dependency<DT>> nextSet = new HashSet<>();

            for (Dependency<DT> parent: set){
                for (Dependency<DT> child: parent.getChildDependencies()){
                    if(!visited.contains(child)){
                        nextSet.add(child);
                        visited.add(child);
                    }
                }
            }
            set = nextSet;
        }
        return visited;
    }
}
