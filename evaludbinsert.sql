insert into filiere(fil_id,fil_nom)values(1,'Informatique');
insert into filiere(fil_id,fil_nom)values(2,'Management');

insert into matiere(mat_id,mat_nom)values(1,'Java');
insert into matiere(mat_id,mat_nom)values(2,'C#');
insert into matiere(mat_id,mat_nom)values(3,'Economie');
insert into matiere(mat_id,mat_nom)values(4,'Langue chinoise');
insert into matiere(mat_id,mat_nom)values(5,'SGBD');
insert into matiere(mat_id,mat_nom)values(6,'Anglais');
insert into matiere(mat_id,mat_nom)values(7,'Development personel');


insert into grade(grad_id,grad_nom)values(1,'Première année');
insert into grade(grad_id,grad_nom)values(2,'Deuxième année');
insert into grade(grad_id,grad_nom)values(3,'Troisième année');
insert into grade(grad_id,grad_nom)values(4,'Quatrième année');
insert into grade(grad_id,grad_nom)values(5,'Cinquième année');


insert into classroom(clas_id,grad_id,fil_id,clas_ann,clas_nom)values(1,1,1,'2021-2022','classe1');
insert into classroom(clas_id,grad_id,fil_id,clas_ann,clas_nom)values(2,2,1,'2021-2022','classe2');
insert into classroom(clas_id,grad_id,fil_id,clas_ann,clas_nom)values(3,3,1,'2021-2022','classe3');
insert into classroom(clas_id,grad_id,fil_id,clas_ann,clas_nom)values(4,4,1,'2021-2022','classe4');
insert into classroom(clas_id,grad_id,fil_id,clas_ann,clas_nom)values(5,5,1,'2021-2022','classe5');
insert into classroom(clas_id,grad_id,fil_id,clas_ann,clas_nom)values(6,1,2,'2021-2022','classe6');
insert into classroom(clas_id,grad_id,fil_id,clas_ann,clas_nom)values(7,2,2,'2021-2022','classe7');
insert into classroom(clas_id,grad_id,fil_id,clas_ann,clas_nom)values(8,3,2,'2021-2022','classe8');
insert into classroom(clas_id,grad_id,fil_id,clas_ann,clas_nom)values(9,4,2,'2021-2022','classe9');
insert into classroom(clas_id,grad_id,fil_id,clas_ann,clas_nom)values(10,5,2,'2021-2022','classe10');


insert into etudiant(ETU_ID ,ETU_EMAIL ,ETU_PASSWORD ,ETU_NOM ,ETU_PRENOM ,ETU_TEL ,ETU_DATE_INSCRI)
values(1,'etudiant1@gmail.com','password1','nometu1','prenometu1','tel1',SYSDATE);
insert into etudiant(ETU_ID ,ETU_EMAIL ,ETU_PASSWORD ,ETU_NOM ,ETU_PRENOM ,ETU_TEL ,ETU_DATE_INSCRI)
values(2,'etudiant2@gmail.com','password2','nometu2','prenometu2','tel2',SYSDATE);
insert into etudiant(ETU_ID ,ETU_EMAIL ,ETU_PASSWORD ,ETU_NOM ,ETU_PRENOM ,ETU_TEL ,ETU_DATE_INSCRI)
values(3,'etudiant3@gmail.com','password3','nometu3','prenometu3','tel3',SYSDATE);
insert into etudiant(ETU_ID ,ETU_EMAIL ,ETU_PASSWORD ,ETU_NOM ,ETU_PRENOM ,ETU_TEL ,ETU_DATE_INSCRI)
values(4,'etudiant4@gmail.com','password4','nometu4','prenometu4','tel4',SYSDATE);
insert into etudiant(ETU_ID ,ETU_EMAIL ,ETU_PASSWORD ,ETU_NOM ,ETU_PRENOM ,ETU_TEL ,ETU_DATE_INSCRI)
values(5,'etudiant5@gmail.com','password5','nometu5','prenometu5','tel5',SYSDATE);
insert into etudiant(ETU_ID ,ETU_EMAIL ,ETU_PASSWORD ,ETU_NOM ,ETU_PRENOM ,ETU_TEL ,ETU_DATE_INSCRI)
values(6,'etudiant6@gmail.com','password6','nometu6','prenometu6','tel6',SYSDATE);


insert into professeur(PROF_ID ,PROF_NOM ,PROF_PRENOM ,PROF_EMAIL ,PROF_PASSWORD ,PROF_TEL)
values(1,'profnom1','profprenom1','prof1@gmail.com','profpass1','proftel1');
insert into professeur(PROF_ID ,PROF_NOM ,PROF_PRENOM ,PROF_EMAIL ,PROF_PASSWORD ,PROF_TEL)
values(2,'profnom2','profprenom2','prof2@gmail.com','profpass2','proftel2');
insert into professeur(PROF_ID ,PROF_NOM ,PROF_PRENOM ,PROF_EMAIL ,PROF_PASSWORD ,PROF_TEL)
values(3,'profnom3','profprenom3','prof3@gmail.com','profpass3','proftel3');
insert into professeur(PROF_ID ,PROF_NOM ,PROF_PRENOM ,PROF_EMAIL ,PROF_PASSWORD ,PROF_TEL)
values(4,'profnom4','profprenom4','prof4@gmail.com','profpass4','proftel4');
insert into professeur(PROF_ID ,PROF_NOM ,PROF_PRENOM ,PROF_EMAIL ,PROF_PASSWORD ,PROF_TEL)
values(5,'profnom5','profprenom5','prof5@gmail.com','profpass5','proftel5');


insert into classeroom_etudiant(etu_id,clas_id)values(1,1);
insert into classeroom_etudiant(etu_id,clas_id)values(2,1);
insert into classeroom_etudiant(etu_id,clas_id)values(3,1);
insert into classeroom_etudiant(etu_id,clas_id)values(4,3);
insert into classeroom_etudiant(etu_id,clas_id)values(5,3);
insert into classeroom_etudiant(etu_id,clas_id)values(6,3);



CREATE SEQUENCE etu_seq
 START WITH     7
 INCREMENT BY   1
NOCACHE
 NOCYCLE;
 CREATE SEQUENCE clas_seq
 START WITH     11
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

 CREATE SEQUENCE prof_seq
 START WITH     6
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 CREATE SEQUENCE exam_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
  CREATE SEQUENCE  ques_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
   CREATE SEQUENCE  choix_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
commit;

















