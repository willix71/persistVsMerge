# persistVsMerge
JPA Merge is Ignored when Persist is set.

The relationship in Entity1 and Entity2 use a CascadeType.ALL (which includes PERSIST and MERGE).

With those settings, test2 and test4 fails with a "detached entity" exception.

When setting the CascadeType to MERGE on it's own, those two tests succeed but the other two fail with either a "unsaved transient instance" exception or a an entity not inserted (which is correct).

What I don't understand is why setting the CascadeType to ALL does successfully run all tests. It's as the PERSIST takes over and the MERGE is totally ignored!!!
