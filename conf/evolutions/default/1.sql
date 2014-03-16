# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table ementa (
  id                        bigint auto_increment not null,
  description               varchar(255),
  price                     varchar(255),
  restaurante_id            bigint,
  constraint pk_ementa primary key (id))
;

create table restaurante (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  description               varchar(255),
  constraint pk_restaurante primary key (id))
;

alter table ementa add constraint fk_ementa_restaurante_1 foreign key (restaurante_id) references restaurante (id) on delete restrict on update restrict;
create index ix_ementa_restaurante_1 on ementa (restaurante_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table ementa;

drop table restaurante;

SET FOREIGN_KEY_CHECKS=1;

