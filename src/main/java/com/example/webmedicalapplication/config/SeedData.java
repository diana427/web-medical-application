package com.example.webmedicalapplication.config;

import com.example.webmedicalapplication.models.Account;
import com.example.webmedicalapplication.models.Authority;
import com.example.webmedicalapplication.models.Card;
import com.example.webmedicalapplication.repositories.AuthorityRepository;
import com.example.webmedicalapplication.services.AccountService;
import com.example.webmedicalapplication.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private CardService cardService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Card> cards = cardService.getAll("keyword");

        if (cards.size() == 0) {

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

            Card card1 = new Card();
            card1.setLastName("Залізняк");
            card1.setFirstName("Максим");
            card1.setCity("Дніпро");
            card1.setAge(41);
            card1.setPhoneNumber(125458351L);
            card1.setEmail("maksym@gmail.com");
            card1.setGender("Чоловік");
            card1.setProblemList("Сильний головний біль, високий артеріальний тиск, запаморочення.");
            card1.setMedications("Бісопролол");
            card1.setAccount(account1);

            Card card2 = new Card();
            card2.setLastName("Феба");
            card2.setFirstName("Коваль");
            card2.setCity("Ужгород");
            card2.setAge(38);
            card2.setPhoneNumber(854665781L);
            card2.setEmail("feba@gmail.com");
            card2.setGender("Жіноча");
            card2.setProblemList("Ниюча біль у спині");
            card2.setMedications("Курс терапії лікувальної гімнастики");
            card2.setAccount(account1);

            Card card3 = new Card();
            card3.setLastName("Шевченко");
            card3.setFirstName("Володимир");
            card3.setCity("Запоріжжя");
            card3.setAge(25);
            card3.setPhoneNumber(845151552L);
            card3.setEmail("volodymyr@kk");
            card3.setGender("Чоловік");
            card3.setProblemList("Проблеми з дихальною системою, астма");
            card3.setMedications("Бронходилататори, кортикостероїди");
            card3.setAccount(account2);

            Card card4 = new Card();
            card4.setLastName("Вугор");
            card4.setFirstName("Олександр");
            card4.setCity("Ужгород");
            card4.setAge(56);
            card4.setPhoneNumber(424275782L);
            card4.setEmail("shuka@kk");
            card4.setGender("Чоловік");
            card4.setProblemList("Проблеми зі слухом, воспалення вуха");
            card4.setMedications("Антибіотики, аудіологічна реабілітація");
            card4.setAccount(account2);

            Card card5 = new Card();
            card5.setLastName("Бречко");
            card5.setFirstName("Марія");
            card5.setCity("Суми");
            card5.setAge(21);
            card5.setPhoneNumber(457527782L);
            card5.setEmail("maria@kk");
            card5.setGender("Жіноча");
            card5.setProblemList("Депресія, тривожність");
            card5.setMedications("Терапія, антидеприсанти");
            card5.setAccount(account1);

            Card card6 = new Card();
            card6.setLastName("Лутай");
            card6.setFirstName("Євгеній");
            card6.setCity("Кривий-Ріг");
            card6.setAge(32);
            card6.setPhoneNumber(754242782L);
            card6.setEmail("lutay@kk");
            card6.setGender("Чоловік");
            card6.setPrivateNumber(1864L);
            card6.setKindOfInjury("Поранення від осколків");
            card6.setProblemList("Осколки кулі, пробоїни органів та розриви м'язів.");
            card6.setMedications("Зупинення кровотечі 08.08.2022, о 13:49. Надано дозу парацетамолу.");
            card6.setAccount(account2);

            Card card7 = new Card();
            card7.setLastName("Андрющенко");
            card7.setFirstName("Максим");
            card7.setCity("Запоріжжя");
            card7.setAge(25);
            card7.setPhoneNumber(845151552L);
            card7.setEmail("maksyml@kk");
            card7.setGender("Чоловік");
            card7.setProblemList("Проблеми з дихальною системою, астма");
            card7.setMedications("Бронходилататори, кортикостероїди");
            card7.setAccount(account1);

            Card card8 = new Card();
            card8.setLastName("Щука");
            card8.setFirstName("Олександр");
            card8.setCity("Ужгород");
            card8.setAge(56);
            card8.setPhoneNumber(424275782L);
            card8.setEmail("shuka@kk");
            card8.setGender("Чоловік");
            card8.setProblemList("Проблеми зі слухом, воспалення вуха");
            card8.setMedications("Антибіотики, аудіологічна реабілітація");
            card8.setAccount(account1);

            Card card9 = new Card();
            card9.setLastName("Бречко");
            card9.setFirstName("Марія");
            card9.setCity("Суми");
            card9.setAge(21);
            card9.setPhoneNumber(457527782L);
            card9.setEmail("maria@kk");
            card9.setGender("Жіноча");
            card9.setProblemList("Депресія, тривожність");
            card9.setMedications("Терапія, антидеприсанти");
            card9.setAccount(account1);

            Card card10 = new Card();
            card10.setLastName("Лутай");
            card10.setFirstName("Євгеній");
            card10.setCity("Кривий-Ріг");
            card10.setAge(32);
            card10.setPhoneNumber(754242782L);
            card10.setEmail("lutay@kk");
            card10.setGender("Чоловік");
            card10.setPrivateNumber(1864L);
            card10.setKindOfInjury("Поранення від осколків");
            card10.setProblemList("Осколки кулі, пробоїни органів та розриви м'язів.");
            card10.setMedications("Зупинення кровотечі 08.08.2022, о 13:49. Надано дозу парацетамолу.");
            card10.setAccount(account2);

            Card card11 = new Card();
            card11.setLastName("Батраченко");
            card11.setFirstName("Василь");
            card11.setCity("Запоріжжя");
            card11.setAge(25);
            card11.setPhoneNumber(845151552L);
            card11.setEmail("vasyl@kk");
            card11.setGender("Чоловік");
            card11.setProblemList("Проблеми з дихальною системою, астма");
            card11.setMedications("Бронходилататори, кортикостероїди");
            card11.setAccount(account2);

            Card card12 = new Card();
            card12.setLastName("Щука");
            card12.setFirstName("Олександр");
            card12.setCity("Ужгород");
            card12.setAge(56);
            card12.setPhoneNumber(424275782L);
            card12.setEmail("shuka@kk");
            card12.setGender("Чоловік");
            card12.setProblemList("Проблеми зі слухом, воспалення вуха");
            card12.setMedications("Антибіотики, аудіологічна реабілітація");
            card12.setAccount(account1);

            Card card13 = new Card();
            card13.setLastName("Бречко");
            card13.setFirstName("Марія");
            card13.setCity("Суми");
            card13.setAge(21);
            card13.setPhoneNumber(457527782L);
            card13.setEmail("maria@kk");
            card13.setGender("Жіноча");
            card13.setProblemList("Депресія, тривожність");
            card13.setMedications("Терапія, антидеприсанти");
            card13.setAccount(account1);

            Card card14 = new Card();
            card14.setLastName("Лутай");
            card14.setFirstName("Євгеній");
            card14.setCity("Кривий-Ріг");
            card14.setAge(32);
            card14.setPhoneNumber(754242782L);
            card14.setEmail("lutay@kk");
            card14.setGender("Чоловік");
            card14.setPrivateNumber(1864L);
            card14.setKindOfInjury("Поранення від осколків");
            card14.setProblemList("Осколки кулі, пробоїни органів та розриви м'язів.");
            card14.setMedications("Зупинення кровотечі 08.08.2022, о 13:49. Надано дозу парацетамолу.");
            card14.setAccount(account2);


            cardService.save(card1);
            cardService.save(card2);
            cardService.save(card3);
            cardService.save(card4);
            cardService.save(card5);
            cardService.save(card6);
            cardService.save(card7);
            cardService.save(card8);
            cardService.save(card9);
            cardService.save(card10);
            cardService.save(card11);
            cardService.save(card12);
            cardService.save(card13);
            cardService.save(card14);
        }
    }
}
