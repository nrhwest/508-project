create table teacher(
  tID integer primary key,
  firstName varchar(30),
  lastName varchar(30),
  workEmail varchar(60),
  personalEmail varchar(60),
  phoneNum varchar(15),
  birthday varchar(50),
  foodAllergies varchar(50),
  schoolName varchar(60),
  subject varchar(50),
  gradeLevel varchar(20)

  FOREIGN KEY (gradeLevel) REFERENCES training(gradeLevel),
  FOREIGN KEY (schoolName) REFERENCES school(schoolName)
);

create table school(
  sID integer primary key,
  schoolName varchar(60),
  phoneNum varchar(15),
  districtName varchar(50),
  principal varchar(50),
  numTeachersSent integer

  FOREIGN KEY (districtName) REFERENCES district(districtName)
);

create table address(
  address varchar(50),
  city varchar(50),
  state varchar(50),
  zipCode integer

  primary key (address)
);

create table district(
  districtName varchar(50) not null,
  superIntendent varchar(50) not null,
  numOfTeachers integer,
  zipCode integer,

  primary key (districtName)
);

create table training(
  trainingName varchar(60),
  maxCapacity integer,
  collegeCredit integer,
  stipend varchar(20),
  numOfRegistrates integer,
  trainingDate varchar(50),
  gradeLevel varchar(20),

  primary key(trainingName)
);

create table session(
  sessionDate varchar(50) not null,
  location varchar(50) not null,
  sessTime varchar (50) not null,

  primary key(sessionDate)
);

create table android_metadata ( locale text default 'en_US' );

insert into android_metadata values ('en_US');

insert into teacher values(1, 'Bob', 'Builder', 'BuilderBob2@rich.edu', 'building247@yahoo.com', 8045437893, '11/11/93', 'Peanut Butter', 'Richmond Elementary School', 'Math', 'ES');
insert into teacher values(2, 'Peter', 'Griffin', 'GriffinPeter23@plz.edu', 'griffinTower@gmail.com', 7579314621, '8/23/90', 'Shrimp','Plaza Middle School', 'Science','HS');
insert into teacher values(3, 'Sarah', 'West', 'WestSarah24@cary.edu', 'Kwest25@yahoo.com', 8042658911, '02/05/99', 'Banana', 'Carytown High School','Math', 'MS');
insert into teacher values(4,	'Aaron', 'Lee',	'LeeAaron9@green.edu', 'Lee784@gmail.com', 8023593842, '7/2/92', 'Pizza', 'Green Valley Elementary School',	'CTE', 'MS');
insert into teacher values(5,	'Susan', 'Luis', 'luisSusan21@hydro.edu',	'SLuis23@yahoo.com', 5054326592, '5/26/94',	'None',	'Hydroflask High School', 'Science', 'ES');

insert into address values('651 West Cary St',	'Richmond',	'VA',	23320);
insert into address values('6464 Hoover Rd',	'Richmond',	'VA',	23329);
insert into address values('8658 Larry Hoover Rd',	'Chesterfield',	'VA',	23643);
insert into address values('5931 Broad St', 'Richmond', 'VA', 23293);
insert into address values('2183 Starbuck Rd', 'Chesterfield',	'VA',	23329);

insert into school values(23,	'Richmond Elementary School', 8044326542, 'Fairfax', 'Hulk Hogan', 10);
insert into school values(26,	'Plaza Middle School', 8045784312, 'Roanoke', 'Ric LaFlair', 4);
insert into school values(35,	'Carytown High School', 8423225842,	'Lynchburg', 'Diana Jackson', 6);
insert into school values(54,	'Green Valley Elementary School', 8046553929,	'Michael Jackson', 11);
insert into school values(29,	'Hydroflask High School', 8424853911,	'Charlottesville', 'Nathan Luu', 3);

insert into training values('Math Magician Project', 110,	3, 'Yes', 95, '3/24/17', 'ES');
insert into training values('Computer Scientist',	200, 0,	'No',	189, '6/9/17', 'HS');
insert into training values('Project Go',	150, 3,	'No', 133, '1/12/17', 'MS');
insert into training values('Train Math',	100, 0,	'Yes', 95, '8/18/17', 'MS');
insert into training values('Logic Project', 170, 3, 'Yes',	145, '5/22/17',	'ES');

insert into session values('3/24/17',	'Richmond',	'5:45 p.m.');
insert into session values('6/9/17', 'Chesterfield', '7:30 a.m.');
insert into session values('1/12/17',	'Chesterfield',	'10:30 a.m');
insert into session values('8/18/17',	'Richmond', '8:45 p.m.');
insert into session values('5/22/17',	'Richmond',	'9:00 p.m.');

insert into district values('Fairfax', 'Dr. Scott Brabrands', 155, 20124);
insert into district values('Roanoke', 'Dr. Mundo West', 190,	23518);
insert into district values('Lynchburg', 'Dr. Nathan West',	175, 27429);
insert into district values('Harrisonburg',	'Dr. Matt Pointer', 200, 20431);
insert into district values('Charlottesville', 'Dr. Andy Bui', 185,	20512);
