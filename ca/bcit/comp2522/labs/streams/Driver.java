package ca.bcit.comp2522.labs.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Driver {

    /*
    * References:
    *   - Java Stream API: https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
    *   - JenKov.com - Java Stream API Tutorial: http://tutorials.jenkov.com/java-functional-programming/streams.html
    *
     */

    public static void main(String[] args) {
        System.out.println("Start");

        Random generator = new Random();

        String[] first_names = {"Edmund", "Kylan", "Reilly", "Zakariah", "Oran", "Luna", "Ziva", "Torin", "Mia-Rose", "Berat", "Leela", "Carmel", "Amiyah", "Hattie", "Sorcha", "Tarik"};
        String[] last_names = {"Terrell", "Cantrell", "Ramirez", "Wilcox", "Guerrero", "Peacock", "Brewer", "Hodges", "Orozco", "Roy", "Burns", "Everett", "Newman", "Simons", "Moses", "Redmond", "McPherson", "Moran", "Carver", "Miller"};

        final int numStudents = 20;
        final int youngestAge = 658814668;  //epoch age in seconds - Nov 11 17 1990
        final int oldestAge = 974433868;  //epoch age in seconds  - Nov 11 17 2000
        final long secondsToMillisecondsConversion = 1000L;
        final int secondsToDaysConversion = 86400;


        //Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("PST"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");

        ArrayList<Student> students = new ArrayList<>();

        //Student student1 = new Student("Edmund", "Terrell", "A91111111", dateFormat.parse("22-01-2000"), Student.Specialty.DATABASE);
        for (int i=0; i<numStudents; i++) {
            Student randStudent = new Student(first_names[generator.nextInt(first_names.length)],
                    last_names[generator.nextInt(last_names.length)],
                    "A" + String.format("%08d", generator.nextInt(99999999)),
                    LocalDate.ofEpochDay((generator.nextInt(oldestAge - youngestAge) + youngestAge)/secondsToDaysConversion),  //1990 to 2000
                    Student.Specialty.values()[generator.nextInt(Student.Specialty.values().length)]);
            students.add(randStudent);
        }

        System.out.println("All Students: ");
        System.out.println(students);


        System.out.println("\n\n");

        //Stream<Student> studentStream = students.stream();

        //Consumer<Student> method = (student) -> { System.out.println(student); };


        /*
        //Example 1
        students.stream()
                //.forEach((Student student) -> { System.out.println("Student: "+student); });
                //.forEach(student -> System.out.println("Student: "+student));
                //.forEach( method );
                .forEach(System.out::println);
        */
        /*
                .forEach(student -> System.out.println("Student: "+student));
                .forEach((Student student) -> { System.out.println("Student: "+student); });

        Consumer<Student> method = (student) -> { System.out.println(student); };

                .forEach( method );
                .forEach(System.out::println);
         */


        /*
        //Example 2
        students.stream()
                //.filter(student -> student.getAge() > 25)
                .filter(student -> student.getStudent_id().startsWith("A9") || student.getStudent_id().startsWith("A8"))
                .filter(student -> student.getSpecialty() == Student.Specialty.PROGRAMMING)
                .forEach(student -> System.out.println("Student: "+student));
        */

        /*  Filters:
                .filter(student -> student.getSpecialty() == Student.Specialty.PROGRAMMING)
                .filter(student -> student.getStudent_id().startsWith("A9") || student.getStudent_id().startsWith("A8"))
                .filter(student -> Period.between(student.getBirth_date(), LocalDate.now()).getYears() > 25)

         */


        /*
        //Example 3
        students.stream()
                //.sorted(new Student.firstNameAscComparator())
                //.sorted(new Student.lastNameDescComparator())
                .sorted(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.getStudent_id().compareTo(o2.getStudent_id());
                    }
                })
                .forEach(student -> System.out.println("Student: "+student));
        */
        /*
            Sorting:
                //.sorted(new Student.firstNameAscComparator())
                .sorted(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o2.getLast_name().compareTo(o1.getLast_name());
                    }
                })
         */

        //Example 4
        System.out.println( "Students' Aggregate: " +
                students.stream()
                .mapToInt(Student::getAge)

                //.mapToInt(student -> student.getAge())  //   [25, 21, 22, 28, 27, 26, ... ]
                .average().orElse(-1)
        );
        OptionalDouble optional =
        students.stream()
                .mapToInt(Student::getAge)

                //.mapToInt(student -> student.getAge())  //   [25, 21, 22, 28, 27, 26, ... ]
                .average();
        if (optional.isEmpty()) {
            System.out.println(-1);
        }
        else {
            optional.getAsDouble();
        }

        /*

            Short form:
                .mapToInt(student -> student.getAge())
                .mapToInt(Student::getAge)

            Aggregate consumers:

             .average()
             .sum()
             .min()
             .max()
             .count()
         */

        /*
        //Example 5
        ArrayList<String> stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        stringList.stream().flatMap(value -> {
                String[] split = value.split(" ");
                return (Stream<String>) Arrays.asList(split).stream();
            })
            .forEach(value -> System.out.println(value))
        ;
        System.out.println("End");
        */
        /*
        //Example 6
        ArrayList<String> stringList2 = new ArrayList<String>();

        stringList2.add("one");
        stringList2.add("two");
        stringList2.add("three");
        stringList2.add("one");
        stringList2.add("two");
        stringList2.add("four");
        stringList2.add("three");


        List<String> distinctStrings = stringList2.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctStrings);
        */
        /*
           Alternate intermediate:
           limit(2)
         */

        /*
          Terminal Consumers:
          anyMatch() - returns true if at least 1 stream element matches the boolean expression
          allMatch() - returns true if ALL stream elements match the boolean expression
          noneMatch() - returns true if NONE stream elements match the boolean expression
         */

        /*
        //Example 7
        try {
            Path currentPath = Paths.get("Patrick Repo/src/res/SherlockHolmes.txt");
            System.out.println(currentPath.toAbsolutePath());

            Path path = Paths.get("Patrick Repo/src/res/SherlockHolmes.txt");
            System.out.println("Number of lines in Sherlock Holmes: "+Files.lines(path).count());
            System.out.println("Number of words in Sherlock Holmes: "+Files.lines(path).flatMap(line -> Arrays.stream(line.split("\\s+"))).count());
        }
        catch(IOException ioe) {
            System.out.println("File not found? Bad Permissions?");
            System.out.println(ioe);
        }
        */

        /* Source / Producers:

         */

    }
}
