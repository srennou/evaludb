alter table CHOIX
   drop constraint FK_CHOIX_QUES_CHOI_QUESTION;

alter table CLASSEROOM_ETUDIANT
   drop constraint FK_CLASSERO_CLASSEROO_ETUDIANT;

alter table CLASSEROOM_ETUDIANT
   drop constraint FK_CLASSERO_CLASSEROO_CLASSROO;

alter table CLASSROOM
   drop constraint FK_CLASSROO_CLASSEROO_FILIERE;

alter table CLASSROOM
   drop constraint FK_CLASSROO_CLASSEROO_GRADE;

alter table CLASSROOM_MATIERE
   drop constraint FK_CLASSROO_CLASSROOM_CLASSROO;

alter table CLASSROOM_MATIERE
   drop constraint FK_CLASSROO_CLASSROOM_PROFESSE;

alter table CLASSROOM_MATIERE
   drop constraint FK_CLASSROO_CLASSROOM_EXAM;

alter table EXAM
   drop constraint FK_EXAM_MAT_EXAM_MATIERE;

alter table PROF_CLAS_MAT
   drop constraint FK_PROF_CLA_PROF_CLAS_MATIERE;

alter table PROF_CLAS_MAT
   drop constraint FK_PROF_CLA_PROF_CLAS_CLASSROO;

alter table PROF_CLAS_MAT
   drop constraint FK_PROF_CLA_PROF_CLAS_PROFESSE;

alter table QUESTION
   drop constraint FK_QUESTION_EXAM_QUES_EXAM;

alter table RESULTAT
   drop constraint FK_RESULTAT_RESULTAT_EXAM;

alter table RESULTAT
   drop constraint FK_RESULTAT_RESULTAT2_ETUDIANT;

drop table CHOIX cascade constraints;

drop table CLASSEROOM_ETUDIANT cascade constraints;

drop table CLASSROOM cascade constraints;

drop table CLASSROOM_MATIERE cascade constraints;

drop table ETUDIANT cascade constraints;

drop table EXAM cascade constraints;

drop table FILIERE cascade constraints;

drop table GRADE cascade constraints;

drop table MATIERE cascade constraints;

drop table PROFESSEUR cascade constraints;

drop table PROF_CLAS_MAT cascade constraints;

drop table QUESTION cascade constraints;

drop table RESULTAT cascade constraints;

/*==============================================================*/
/* Table: CHOIX                                                 */
/*==============================================================*/
create table CHOIX 
(
   CHOIX_ID             number(10)              not null,
   QUES_ID              number(10)              not null,
   CHOIX_DES            VARCHAR2(200),
   CHOIX_STATUT         number(10),
   constraint PK_CHOIX primary key (CHOIX_ID)
);

/*==============================================================*/
/* Table: CLASSEROOM_ETUDIANT                                   */
/*==============================================================*/
create table CLASSEROOM_ETUDIANT 
(
   ETU_ID               number(10)              not null,
   CLAS_ID              number(10)              not null,
   constraint PK_CLASSEROOM_ETUDIANT primary key (ETU_ID, CLAS_ID)
);

/*==============================================================*/
/* Table: CLASSROOM                                             */
/*==============================================================*/
create table CLASSROOM 
(
   CLAS_ID              number(10)              not null,
   GRAD_ID              number(10)              not null,
   FIL_ID               number(10)              not null,
   CLAS_ANN             VARCHAR2(50),
   CLAS_NOM             VARCHAR2(50) unique,
   constraint PK_CLASSROOM primary key (CLAS_ID)
);

/*==============================================================*/
/* Table: CLASSROOM_MATIERE                                     */
/*==============================================================*/
create table CLASSROOM_MATIERE 
(
   CLAS_ID              number(10)              not null,
   PROF_ID              number(10)              not null,
   EXAM_ID              number(10)              not null,
   constraint PK_CLASSROOM_MATIERE primary key (CLAS_ID, PROF_ID, EXAM_ID)
);

/*==============================================================*/
/* Table: ETUDIANT                                              */
/*==============================================================*/
create table ETUDIANT 
(
   ETU_ID               number(10)              not null,
   ETU_EMAIL            VARCHAR2(50) unique ,
   ETU_PASSWORD         VARCHAR2(20),
   ETU_NOM              VARCHAR2(50),
   ETU_PRENOM           VARCHAR2(50),
   ETU_TEL              VARCHAR2(20),
   ETU_DATE_INSCRI      DATE,
   constraint PK_ETUDIANT primary key (ETU_ID)
);

/*==============================================================*/
/* Table: EXAM                                                  */
/*==============================================================*/
create table EXAM 
(
   EXAM_ID              number(10)              not null,
   MAT_ID               number(10)              not null,
   EXAM_NOM             VARCHAR2(100),
   EXAM_NUM             number(10),
   constraint PK_EXAM primary key (EXAM_ID)
);

/*==============================================================*/
/* Table: FILIERE                                               */
/*==============================================================*/
create table FILIERE 
(
   FIL_ID               number(10)              not null,
   FIL_NOM              VARCHAR2(50),
   constraint PK_FILIERE primary key (FIL_ID)
);

/*==============================================================*/
/* Table: GRADE                                                 */
/*==============================================================*/
create table GRADE 
(
   GRAD_ID              number(10)              not null,
   GRAD_NOM             VARCHAR2(50),
   constraint PK_GRADE primary key (GRAD_ID)
);

/*==============================================================*/
/* Table: MATIERE                                               */
/*==============================================================*/
create table MATIERE 
(
   MAT_ID               number(10)              not null,
   MAT_NOM              VARCHAR2(50),
   constraint PK_MATIERE primary key (MAT_ID)
);

/*==============================================================*/
/* Table: PROFESSEUR                                            */
/*==============================================================*/
create table PROFESSEUR 
(
   PROF_ID              number(10)              not null,
   PROF_NOM             VARCHAR2(50),
   PROF_PRENOM          VARCHAR2(50),
   PROF_EMAIL           VARCHAR2(50) unique,
   PROF_PASSWORD        VARCHAR2(20),
   PROF_TEL             VARCHAR2(20),
   constraint PK_PROFESSEUR primary key (PROF_ID)
);

/*==============================================================*/
/* Table: PROF_CLAS_MAT                                         */
/*==============================================================*/
create table PROF_CLAS_MAT 
(
   MAT_ID               number(10)              not null,
   CLAS_ID              number(10)              not null,
   PROF_ID              number(10)              not null,
   constraint PK_PROF_CLAS_MAT primary key (MAT_ID, CLAS_ID, PROF_ID)
);

/*==============================================================*/
/* Table: QUESTION                                              */
/*==============================================================*/
create table QUESTION 
(
   QUES_ID              number(10)              not null,
   EXAM_ID              number(10)              not null,
   QUES_NUM             number(10),
   QUES_DES             VARCHAR2(400),
   constraint PK_QUESTION primary key (QUES_ID)
);

/*==============================================================*/
/* Table: RESULTAT                                              */
/*==============================================================*/
create table RESULTAT 
(
   EXAM_ID              number(10)              not null,
   ETU_ID               number(10)              not null,
   RES_NOTE             number(10,2),
   constraint PK_RESULTAT primary key (EXAM_ID, ETU_ID)
);

alter table CHOIX
   add constraint FK_CHOIX_QUES_CHOI_QUESTION foreign key (QUES_ID)
      references QUESTION (QUES_ID);

alter table CLASSEROOM_ETUDIANT
   add constraint FK_CLASSERO_CLASSEROO_ETUDIANT foreign key (ETU_ID)
      references ETUDIANT (ETU_ID);

alter table CLASSEROOM_ETUDIANT
   add constraint FK_CLASSERO_CLASSEROO_CLASSROO foreign key (CLAS_ID)
      references CLASSROOM (CLAS_ID);

alter table CLASSROOM
   add constraint FK_CLASSROO_CLASSEROO_FILIERE foreign key (FIL_ID)
      references FILIERE (FIL_ID);

alter table CLASSROOM
   add constraint FK_CLASSROO_CLASSEROO_GRADE foreign key (GRAD_ID)
      references GRADE (GRAD_ID);

alter table CLASSROOM_MATIERE
   add constraint FK_CLASSROO_CLASSROOM_CLASSROO foreign key (CLAS_ID)
      references CLASSROOM (CLAS_ID);

alter table CLASSROOM_MATIERE
   add constraint FK_CLASSROO_CLASSROOM_PROFESSE foreign key (PROF_ID)
      references PROFESSEUR (PROF_ID);

alter table CLASSROOM_MATIERE
   add constraint FK_CLASSROO_CLASSROOM_EXAM foreign key (EXAM_ID)
      references EXAM (EXAM_ID);

alter table EXAM
   add constraint FK_EXAM_MAT_EXAM_MATIERE foreign key (MAT_ID)
      references MATIERE (MAT_ID);

alter table PROF_CLAS_MAT
   add constraint FK_PROF_CLA_PROF_CLAS_MATIERE foreign key (MAT_ID)
      references MATIERE (MAT_ID);

alter table PROF_CLAS_MAT
   add constraint FK_PROF_CLA_PROF_CLAS_CLASSROO foreign key (CLAS_ID)
      references CLASSROOM (CLAS_ID);

alter table PROF_CLAS_MAT
   add constraint FK_PROF_CLA_PROF_CLAS_PROFESSE foreign key (PROF_ID)
      references PROFESSEUR (PROF_ID);

alter table QUESTION
   add constraint FK_QUESTION_EXAM_QUES_EXAM foreign key (EXAM_ID)
      references EXAM (EXAM_ID);

alter table RESULTAT
   add constraint FK_RESULTAT_RESULTAT_EXAM foreign key (EXAM_ID)
      references EXAM (EXAM_ID);

alter table RESULTAT
   add constraint FK_RESULTAT_RESULTAT2_ETUDIANT foreign key (ETU_ID)
      references ETUDIANT (ETU_ID);
