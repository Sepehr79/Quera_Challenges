package highest_dependency.algorithm;


import java.util.HashSet;
import java.util.Set;

/**
 * Express a dependency
 * @param <DT> Generic datatype
 */
public class Dependency<DT> {

    private final Set<Dependency<DT>> childDependencies = new HashSet<>();

    private final DT value;

    public boolean addChildDependency(Dependency<DT> dtDependency){
        return childDependencies.add(dtDependency);
    }

    public Dependency(DT value){
        this.value = value;
    }

    public Set<Dependency<DT>> getChildDependencies() {
        return childDependencies;
    }

    public DT getValue() {
        return value;
    }

    @Override
    public boolean equals(Object object){
        Dependency<DT> dependency = (Dependency<DT>) object;
        return this.value.equals(dependency.getValue());
    }

    @Override
    public int hashCode(){
        return value.hashCode();
    }
}
