import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FlatMapperExample {

    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Peter",24,Arrays.asList("14","58")),
                new User("John",24,Arrays.asList("66","10")),
                new User("Bob",24,Arrays.asList("48","98")),
                new User("Ala",24,Arrays.asList("20","31"))
                );



        //search For a specific element (Not working as expected yet)

        Optional<String> stringOptional = users.stream()
                .map(user -> user.getPhoneNumbers().stream())
                .flatMap(stringStream -> stringStream.filter(phonNum -> phonNum.equals("90")))
                .findAny();


        stringOptional.ifPresent(System.out::println);









    }

    private static boolean isNotAla(String name) {
        return !name.equals("Ala");
    }

    static class User{
        private String name;
        private Integer age = 30;

        public List<String> getPhoneNumbers() {
            return phoneNumbers;
        }

        public void setPhoneNumbers(List<String> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
        }

        private List<String> phoneNumbers;


        public User(String name) {
            this.name = name;
        }

        public User(String name, Integer age, List<String> phoneNumbers) {
            this.name = name;
            this.age = age;
            this.phoneNumbers = phoneNumbers;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }


        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
