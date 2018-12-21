package com;

import entity.Student;

import java.util.Arrays;
/*import java.util.HashMap;*/
import java.util.List;
import java.util.Map;
/*import java.util.function.Function;*/
import java.util.stream.Collectors;
/*import java.util.Map;
import java.util.stream.Collectors;*/


public class Test {
    public static void main(String[] args) {
        List<Student>list = Arrays.asList(new Student(1,"lc",22),new Student(2,"lssi",23),
                new Student(3,"wangwu",23));
        //这是根据id来进行分组结果为
        /**
         * Key = 1, Value = [Student(id=1, name=lc, age=22)]
         * Key = 2, Value = [Student(id=2, name=lssi, age=23)]
         * Key = 3, Value = [Student(id=3, name=wangwu, age=23)]
         */
        /*Map<Integer, List<Student>> collect = list.stream().collect(Collectors.groupingBy(Student::getId));
        for (Map.Entry<Integer, List<Student>> entry : collect.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }*/
        //这里是根据某个属性进行分组计数
        /**
         * Key = 1, Value = 1
         * Key = 2, Value = 1
         * Key = 3, Value = 1
         */
       /* Map<Integer, Long> collect = list.stream().collect(Collectors.groupingBy(Student::getId, Collectors.counting()));
        for(Map.Entry<Integer, Long> entry:collect.entrySet()){
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }*/
       //根据对象分组计数
        /**
         * Key = Student(id=2, name=lssi, age=23), Value = 1
         * Key = Student(id=3, name=wangwu, age=23), Value = 1
         * Key = Student(id=1, name=lc, age=22), Value = 1
         */
        /*Map<Student, Long> collect = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for(Map.Entry<Student, Long> entry:collect.entrySet()){
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }*/
        //根据分组的key值对结果进行排序、放进另一个map中并输出
        /**
         * Key = 1, Value = 1
         * Key = 2, Value = 1
         * Key = 3, Value = 1
         */
       /* Map<Integer,Long> xMap=new HashMap<>();
        Map<Integer, Long> collect = list.stream().collect(Collectors.groupingBy(Student::getId, Collectors.counting()));
        collect.entrySet().stream().sorted(Map.Entry.<Integer,Long>comparingByKey().reversed()) //reversed不生效
                .forEachOrdered(x->xMap.put(x.getKey(),x.getValue()));
        for(Map.Entry<Integer, Long> entry:xMap.entrySet()){
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }*/
        /**
         * Key = 1, Value = 1
         * Key = 2, Value = 2
         * Key = 3, Value = 3
         */
        Map<Integer, Integer> collect = list.stream().collect(
                Collectors.groupingBy(Student::getId, Collectors.summingInt(Student::getId))
        );
        for(Map.Entry<Integer, Integer> entry:collect.entrySet()){
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }
}
