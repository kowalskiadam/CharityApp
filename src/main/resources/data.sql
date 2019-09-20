insert into categories (name) values ("category 1");
insert into categories (name) values ("category 2");
insert into categories (name) values ("category 3");

insert into institutions (description, name) values ("Fundacja, która pomaga zwierzętom", "Podaj łapę");
insert into institutions (description, name) values ("Fundacja dla dzieci", "Lepsze jutro");
insert into institutions (description, name) values ("Pomagamy bezdomnym", "Nowa szansa");
insert into institutions (description, name) values ("Fundacja, która promuje bezpieczeństwo na drogach", "Zwolnij");

insert into donations (city, pick_up_comment, pick_up_date, pick_up_time, quantity, street, zip_code, institution_id) values ("Warszawa", "Trudny dojazd", 20191005, "11:00:00", 3, "Jerozolimsie 11/3", "01-100", 2);
insert into donations (city, pick_up_comment, pick_up_date, pick_up_time, quantity, street, zip_code, institution_id) values ("Warszawa", "Trudny dojazd", 20191006, "13:00:00", 11, "Jerozolimsie 11/3", "03-100", 2);
insert into donations (city, pick_up_comment, pick_up_date, pick_up_time, quantity, street, zip_code, institution_id) values ("Kraków", "Trudny dojazd", 20191006, "15:00:00", 5, "Jerozolimsie 11/3", "01-100", 1);
insert into donations (city, pick_up_comment, pick_up_date, pick_up_time, quantity, street, zip_code, institution_id) values ("Kraków", "Trudny dojazd", 20191009, "19:00:00", 1, "Jerozolimsie 11/3", "03-100", 4);

insert into donations_categories (donation_id, categories_id) values (1,1);
insert into donations_categories (donation_id, categories_id) values (2,1);
insert into donations_categories (donation_id, categories_id) values (3,2);
insert into donations_categories (donation_id, categories_id) values (4,3);