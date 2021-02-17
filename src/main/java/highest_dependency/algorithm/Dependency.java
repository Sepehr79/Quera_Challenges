package highest_dependency.algorithm;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * Express a dependency
 * @param <DT> Generic datatype
 */
@Getter @RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"childDependencies"})
public class Dependency<DT> {

    private final Set<Dependency<DT>> childDependencies = new HashSet<>();

    private @NonNull final DT value;

    public boolean addChildDependency(Dependency<DT> dtDependency){
        return childDependencies.add(dtDependency);
    }


}
