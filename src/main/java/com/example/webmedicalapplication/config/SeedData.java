package com.example.webmedicalapplication.config;

import com.example.webmedicalapplication.models.Account;
import com.example.webmedicalapplication.models.Authority;
import com.example.webmedicalapplication.models.Post;
import com.example.webmedicalapplication.repositories.AuthorityRepository;
import com.example.webmedicalapplication.services.AccountService;
import com.example.webmedicalapplication.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAll("keyword");

        if (posts.size() == 0) {

            Authority admin = new Authority();
            admin.setName("ROLE_ADMIN");
            authorityRepository.save(admin);

            Authority user = new Authority();
            user.setName("ROLE_USER");
            authorityRepository.save(user);

            Account account1 = new Account();
            Account account2 = new Account();

            account1.setFirstName("Олена");
            account1.setLastName("Лутай");
            account1.setEmail("olenaDoctor@gmail.com");
            account1.setPassword("4321");
            Set<Authority> authorities1 = new HashSet<>();
            authorityRepository.findById("ROLE_USER").ifPresent(authorities1::add);
            account1.setAuthorities(authorities1);

            account2.setFirstName("Марія");
            account2.setLastName("Шевченко");
            account2.setEmail("mariaDoctor@gmail.com");
            account2.setPassword("4321");
            Set<Authority> authorities2 = new HashSet<>();
            authorityRepository.findById("ROLE_ADMIN").ifPresent(authorities2::add);
            authorityRepository.findById("ROLE_USER").ifPresent(authorities2::add);
            account2.setAuthorities(authorities2);

            accountService.save(account1);
            accountService.save(account2);

            Post post1 = new Post();
            post1.setLastName("Залізняк");
            post1.setFirstName("Максим");
            post1.setCity("Дніпро");
            post1.setAge(41);
            post1.setPhoneNumber(125458351L);
            post1.setEmail("maksym@gmail.com");
            post1.setGender("Чоловік");
            post1.setProblemList("Сильний головний біль, високий артеріальний тиск, запаморочення.");
            post1.setMedications("Бісопролол");
            post1.setAccount(account1);

            Post post2 = new Post();
            post2.setLastName("Феба");
            post2.setFirstName("Коваль");
            post2.setCity("Ужгород");
            post2.setAge(38);
            post2.setPhoneNumber(854665781L);
            post2.setEmail("feba@gmail.com");
            post2.setGender("Жіноча");
            post2.setProblemList("Ниюча біль у спині");
            post2.setMedications("Курс терапії лікувальної гімнастики");
            post2.setAccount(account1);

            Post post3 = new Post();
            post3.setLastName("Шевченко");
            post3.setFirstName("Володимир");
            post3.setCity("Запоріжжя");
            post3.setAge(25);
            post3.setPhoneNumber(845151552L);
            post3.setEmail("volodymyr@kk");
            post3.setGender("Чоловік");
            post3.setProblemList("Проблеми з дихальною системою, астма");
            post3.setMedications("Бронходилататори, кортикостероїди");
            post3.setAccount(account2);

            Post post4 = new Post();
            post4.setLastName("Вугор");
            post4.setFirstName("Олександр");
            post4.setCity("Ужгород");
            post4.setAge(56);
            post4.setPhoneNumber(424275782L);
            post4.setEmail("shuka@kk");
            post4.setGender("Чоловік");
            post4.setProblemList("Проблеми зі слухом, воспалення вуха");
            post4.setMedications("Антибіотики, аудіологічна реабілітація");
            post4.setAccount(account2);

            Post post5 = new Post();
            post5.setLastName("Бречко");
            post5.setFirstName("Марія");
            post5.setCity("Суми");
            post5.setAge(21);
            post5.setPhoneNumber(457527782L);
            post5.setEmail("maria@kk");
            post5.setGender("Жіноча");
            post5.setProblemList("Депресія, тривожність");
            post5.setMedications("Терапія, антидеприсанти");
            post5.setAccount(account1);

            Post post6 = new Post();
            post6.setLastName("Лутай");
            post6.setFirstName("Євгеній");
            post6.setCity("Кривий-Ріг");
            post6.setAge(32);
            post6.setPhoneNumber(754242782L);
            post6.setEmail("lutay@kk");
            post6.setGender("Чоловік");
            post6.setPrivateNumber(1864L);
            post6.setKindOfInjury("Поранення від осколків");
            post6.setProblemList("Осколки кулі, пробоїни органів та розриви м'язів.");
            post6.setMedications("Зупинення кровотечі 08.08.2022, о 13:49. Надано дозу парацетамолу.");
            post6.setAccount(account2);

            Post post7 = new Post();
            post7.setLastName("Андрющенко");
            post7.setFirstName("Максим");
            post7.setCity("Запоріжжя");
            post7.setAge(25);
            post7.setPhoneNumber(845151552L);
            post7.setEmail("maksyml@kk");
            post7.setGender("Чоловік");
            post7.setProblemList("Проблеми з дихальною системою, астма");
            post7.setMedications("Бронходилататори, кортикостероїди");
            post7.setAccount(account1);

            Post post8 = new Post();
            post8.setLastName("Щука");
            post8.setFirstName("Олександр");
            post8.setCity("Ужгород");
            post8.setAge(56);
            post8.setPhoneNumber(424275782L);
            post8.setEmail("shuka@kk");
            post8.setGender("Чоловік");
            post8.setProblemList("Проблеми зі слухом, воспалення вуха");
            post8.setMedications("Антибіотики, аудіологічна реабілітація");
            post8.setAccount(account1);

            Post post9 = new Post();
            post9.setLastName("Бречко");
            post9.setFirstName("Марія");
            post9.setCity("Суми");
            post9.setAge(21);
            post9.setPhoneNumber(457527782L);
            post9.setEmail("maria@kk");
            post9.setGender("Жіноча");
            post9.setProblemList("Депресія, тривожність");
            post9.setMedications("Терапія, антидеприсанти");
            post9.setAccount(account1);

            Post post10 = new Post();
            post10.setLastName("Лутай");
            post10.setFirstName("Євгеній");
            post10.setCity("Кривий-Ріг");
            post10.setAge(32);
            post10.setPhoneNumber(754242782L);
            post10.setEmail("lutay@kk");
            post10.setGender("Чоловік");
            post10.setPrivateNumber(1864L);
            post10.setKindOfInjury("Поранення від осколків");
            post10.setProblemList("Осколки кулі, пробоїни органів та розриви м'язів.");
            post10.setMedications("Зупинення кровотечі 08.08.2022, о 13:49. Надано дозу парацетамолу.");
            post10.setAccount(account2);

            Post post11 = new Post();
            post11.setLastName("Батраченко");
            post11.setFirstName("Василь");
            post11.setCity("Запоріжжя");
            post11.setAge(25);
            post11.setPhoneNumber(845151552L);
            post11.setEmail("vasyl@kk");
            post11.setGender("Чоловік");
            post11.setProblemList("Проблеми з дихальною системою, астма");
            post11.setMedications("Бронходилататори, кортикостероїди");
            post11.setAccount(account2);

            Post post12 = new Post();
            post12.setLastName("Щука");
            post12.setFirstName("Олександр");
            post12.setCity("Ужгород");
            post12.setAge(56);
            post12.setPhoneNumber(424275782L);
            post12.setEmail("shuka@kk");
            post12.setGender("Чоловік");
            post12.setProblemList("Проблеми зі слухом, воспалення вуха");
            post12.setMedications("Антибіотики, аудіологічна реабілітація");
            post12.setAccount(account1);

            Post post13 = new Post();
            post13.setLastName("Бречко");
            post13.setFirstName("Марія");
            post13.setCity("Суми");
            post13.setAge(21);
            post13.setPhoneNumber(457527782L);
            post13.setEmail("maria@kk");
            post13.setGender("Жіноча");
            post13.setProblemList("Депресія, тривожність");
            post13.setMedications("Терапія, антидеприсанти");
            post13.setAccount(account1);

            Post post14 = new Post();
            post14.setLastName("Лутай");
            post14.setFirstName("Євгеній");
            post14.setCity("Кривий-Ріг");
            post14.setAge(32);
            post14.setPhoneNumber(754242782L);
            post14.setEmail("lutay@kk");
            post14.setGender("Чоловік");
            post14.setPrivateNumber(1864L);
            post14.setKindOfInjury("Поранення від осколків");
            post14.setProblemList("Осколки кулі, пробоїни органів та розриви м'язів.");
            post14.setMedications("Зупинення кровотечі 08.08.2022, о 13:49. Надано дозу парацетамолу.");
            post14.setAccount(account2);


            postService.save(post1);
            postService.save(post2);
            postService.save(post3);
            postService.save(post4);
            postService.save(post5);
            postService.save(post6);
            postService.save(post7);
            postService.save(post8);
            postService.save(post9);
            postService.save(post10);
            postService.save(post11);
            postService.save(post12);
            postService.save(post13);
            postService.save(post14);
        }
    }
}
