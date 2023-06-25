package edu.curtin.polyfind.tree;
import edu.curtin.polyfind.definitions.*;

import java.util.*;

public abstract class TypeNode implements Comparable<TypeNode>
{
    // private final String name;
    // private final boolean isClass;
    // private final Optional<TypeDefinition> defn;
    // private final Category category;
    private final List<TypeNode> parents = new ArrayList<>();
    private final List<TypeNode> children = new ArrayList<>();
    private final List<MethodNode> methods = new ArrayList<>();

    // public TypeNode(TypeDefinition defn)
    // {
    //     this.defn = Optional.of(defn);
    //     // this.file = defn.getSourceFile();
    //     this.name = defn.getName();
    //     this.isClass = defn.isClass();
    // }
    //
    // public TypeNode(String name, boolean isClass)
    // {
    //     // this.file = Optional.empty();
    //     this.defn = Optional.empty();
    //     this.name = name;
    //     this.isClass = isClass;
    // }

    // public TypeNode(Category category)
    // {
    //     this.category = category;
    // }

    public void addParent(TypeNode parent)
    {
        parents.add(parent);
    }

    public void addChild(TypeNode child)
    {
        children.add(child);
    }

    public void addMethod(MethodNode method)
    {
        methods.add(method);
    }

    // public Optional<SourceFile> getSourceFile()
    // {
    //     return defn.flatMap(TypeDefinition::getSourceFile);
    // }

    public abstract Optional<SourceFile> getSourceFile();
    public abstract String getName();
    public abstract Optional<TypeDefinition> getDefinition();
    public abstract TypeCategory getCategory();
    public abstract String getConstruct();

    // public Category getCategory()
    // {
    //     return category;
    // }

    public List<TypeNode> getParents() { return Collections.unmodifiableList(parents); }
    public List<TypeNode> getChildren() { return Collections.unmodifiableList(children); }
    public List<MethodNode> getMethods() { return Collections.unmodifiableList(methods); }

    // @Override
    // public String toString()
    // {
    //     // return (isClass ? "class " : "interface ") + name + " (" + file.map(f -> f.getName()).orElse("no source") + ")";
    //     return
    //         defn.map(d -> d.getConstruct()).orElseGet(() -> isClass ? "class " : "interface ")
    //         + name
    //         + " ("
    //         + getSourceFile().map(f -> f.getPath().toString()).orElse("no source")
    //         + ")";
    // }

    @Override
    public int compareTo(TypeNode other)
    {
        return getName().compareTo(other.getName());
    }

    // @Override
    // public boolean equals(Object other)
    // {
    //     if(!(other instanceof TypeNode)) { return false; }
    //     var otherType = (TypeNode)other;
    //     return name.equals(otherType.name) &&
    //         // ((file == null) ? (otherType.file == null) : Objects.equals(file.getPackage(), otherType.file.getPackage()));
    //         getFile().map(SourceFile::getPackage).equals(
    //             otherType.getFile().map(SourceFile::getPackage));
    // }

    // @Override
    // public boolean equals(Object other)
    // {
    //     if(!(other instanceof TypeNode)) { return false; }
    //     var otherType = (TypeNode)other;
    //     return name.equals(otherType.name) && defn.equals(otherType.defn);
    // }

    // @Override
    // public int hashCode()
    // {
    //     // return Objects.hash(name, (file == null) ? null : file.getPackage());
    //     // return Objects.hash(name, file.map(SourceFile::getPackage));
    //     return Objects.hash(name, defn);
    // }

    @Override
    public abstract boolean equals(Object other);

    @Override
    public abstract int hashCode();

    @Override
    public abstract String toString();
}


// package edu.curtin.polyfind.tree;
// import edu.curtin.polyfind.definitions.*;
//
// import java.util.*;
//
// public class TypeNode implements Comparable<TypeNode>
// {
//     // private final Optional<SourceFile> file;
//     private final String name;
//     private final boolean isClass;
//     private final Optional<TypeDefinition> defn;
//     private final List<TypeNode> parents = new ArrayList<>();
//     private final List<TypeNode> children = new ArrayList<>();
//     private final List<MethodNode> methods = new ArrayList<>();
//
//     public TypeNode(TypeDefinition defn)
//     {
//         this.defn = Optional.of(defn);
//         // this.file = defn.getSourceFile();
//         this.name = defn.getName();
//         this.isClass = defn.isClass();
//     }
//
//     public TypeNode(String name, boolean isClass)
//     {
//         // this.file = Optional.empty();
//         this.defn = Optional.empty();
//         this.name = name;
//         this.isClass = isClass;
//     }
//
//     public void addParent(TypeNode parent)
//     {
//         parents.add(parent);
//     }
//
//     public void addChild(TypeNode child)
//     {
//         children.add(child);
//     }
//
//     public void addMethod(MethodNode method)
//     {
//         methods.add(method);
//     }
//
//     public Optional<SourceFile> getSourceFile()
//     {
//         return defn.flatMap(TypeDefinition::getSourceFile);
//     }
//
//     public String getName() { return name; }
//     public boolean isClass() { return isClass; }
//     public Optional<TypeDefinition> getDefinition() { return defn; }
//     public List<TypeNode> getParents() { return Collections.unmodifiableList(parents); }
//     public List<TypeNode> getChildren() { return Collections.unmodifiableList(children); }
//     public List<MethodNode> getMethods() { return Collections.unmodifiableList(methods); }
//
//     @Override
//     public String toString()
//     {
//         // return (isClass ? "class " : "interface ") + name + " (" + file.map(f -> f.getName()).orElse("no source") + ")";
//         return
//             defn.map(d -> d.getConstruct()).orElseGet(() -> isClass ? "class " : "interface ")
//             + name
//             + " ("
//             + getSourceFile().map(f -> f.getPath().toString()).orElse("no source")
//             + ")";
//     }
//
//     @Override
//     public int compareTo(TypeNode other)
//     {
//         return name.compareTo(other.name);
//     }
//
//     // @Override
//     // public boolean equals(Object other)
//     // {
//     //     if(!(other instanceof TypeNode)) { return false; }
//     //     var otherType = (TypeNode)other;
//     //     return name.equals(otherType.name) &&
//     //         // ((file == null) ? (otherType.file == null) : Objects.equals(file.getPackage(), otherType.file.getPackage()));
//     //         getFile().map(SourceFile::getPackage).equals(
//     //             otherType.getFile().map(SourceFile::getPackage));
//     // }
//
//     @Override
//     public boolean equals(Object other)
//     {
//         if(!(other instanceof TypeNode)) { return false; }
//         var otherType = (TypeNode)other;
//         return name.equals(otherType.name) && defn.equals(otherType.defn);
//     }
//
//     @Override
//     public int hashCode()
//     {
//         // return Objects.hash(name, (file == null) ? null : file.getPackage());
//         // return Objects.hash(name, file.map(SourceFile::getPackage));
//         return Objects.hash(name, defn);
//     }
// }
