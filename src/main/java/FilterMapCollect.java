import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterMapCollect {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ala","jhon","sam","messi");

        for(String name:names){
            if (!name.equals("sam")){
                System.out.println(name);
            }
        }

        names.stream().filter(name -> isNotAla(name))
                .forEach(System.out::println);


       List<User> userList =  names.stream()
                .filter(FilterMapCollect::isNotAla)
                .map(User::new)
                .collect(Collectors.toList());




    }

    private static boolean isNotAla(String name) {
        return !name.equals("Ala");
    }

   static class User{
        private String name;
        private Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public User(String name) {
            this.name = name;
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
