create table address(
  streetName text,
  city text,
  state text,
  zipCode integer,

  primary key (city)
);

create table session(
  sessionDate text not null,
  city text not null,
  sessTime text not null,

  primary key(sessionDate),
  CONSTRAINT `session_ibfk_1` FOREIGN KEY (`city`) REFERENCES `address` (`city`) ON DELETE CASCADE
);

create table training(
  trainingName text,
  maxCapacity integer,
  collegeCredit integer,
  stipend text,
  numOfRegistrates integer,
  sessionDate text not null,
  gradeLevel text,

  primary key(trainingName),
  CONSTRAINT `training_ibfk_1` FOREIGN KEY (`sessionDate`) REFERENCES `session` (`sessionDate`) ON DELETE CASCADE

);

create table district(
  dID integer,
  districtName text not null,
  superIntendent text not null,
  numOfTeachers integer,
  zipCode integer,

  primary key (dID)
);

create table school(
  sID integer,
  schoolName text,
  phoneNum text,
  districtName text not null,
  dID integer,
  principal text,
  numTeachersSent integer,

  primary key (sID),
  CONSTRAINT `school_ibfk_1` FOREIGN KEY (`dID`) REFERENCES `district` (`dID`) ON DELETE CASCADE
);

create table teacher(
  tID integer,
  firstName text,
  lastName text,
  workEmail text,
  phoneNum text,
  schoolName text not null,
  sID integer,
  subject text,
  gradeLevel text not null,

  primary key (tID),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`sID`) REFERENCES `school` (`sID`) ON DELETE CASCADE
);

create table android_metadata ( locale text default 'en_US' );

insert into android_metadata values ('en_US');

insert into address values('651 West Cary St',	'Petersburg',	'VA',	23320);
insert into address values('8658 Larry Hoover Rd', 'Chesterfield',	'VA',	23643);
insert into address values('5931 Broad St', 'Richmond', 'VA', 23293);

insert into session values('6/9/17', 'Chesterfield', '7:30 a.m.');
insert into session values('8/18/17',	'Richmond', '9:00 a.m.');
insert into session values('5/22/17',	'Petersburg',	'10:00 a.m.');

insert into training values('Train Math',	100, 0,	'Yes', 95, '8/18/17', 'MS');
insert into training values('Logic Project', 170, 3, 'Yes',	145, '5/22/17',	'ES');
insert into training values('Computer Scientist',	200, 0,	'No',	189, '6/9/17', 'HS');

insert into district values(643, 'Fairfax', 'Dr. Scott Brabrands', 155, 20124);
insert into district values(938, 'Roanoke', 'Dr. Mundo West', 190,	23518);
insert into district values(237, 'Lynchburg', 'Dr. Nathan West',	175, 27429);
insert into district values(471, 'Harrisonburg',	'Dr. Matt Pointer', 200, 20431);
insert into district values(175, 'Charlottesville', 'Dr. Andy Bui', 185,	20512);
insert into district values(428, 'Amherst', 'Dr. Joann Watson', 301, 23406);
insert into district values(385, 'Henrico', 'Vicki West', 240, 28401);
insert into district values(204, 'Richmond', 'Dr. Katherine McGuire', 384, 29582);
insert into district values(375, 'Stafford', 'Dr. Luther Smith', 210, 27810);

insert into school values(23,	'Richmond Elementary School', 8044326542, 'Fairfax', 643, 'Hulk Hogan', 1);
insert into school values(26,	'Plaza Middle School', 8045784312, 'Roanoke', 938,'Ric LaFlair', 2);
insert into school values(35,	'Carytown High School', 8423225842,	'Lynchburg', 237,'Diana Jackson', 2);
insert into school values(54,	'Green Valley Elementary School', 8046553929, 'Harrisonburg', 471,'Michael Jackson', 3);
insert into school values(29,	'Hydroflask High School', 8424853911,	'Charlottesville', 175,'Nathan Luu', 1);
insert into school values(47,	'Centreville High School', 7038474921,	'Amherst', 428, 'Kanye West', 1);
insert into school values(10, 'Liberty Middle School', 5719746026, 'Henrico', 385, 'Modi Khamis', 1);
insert into school values(30, 'Lincoln Elementary School', 5714925026, 'Richmond', 204, 'Martin Luther', 1);
insert into school values(25, 'Franklin Middle School', 8306738172, 'Stafford', 375, 'Gandhi', 1);
insert into school values(58, 'Littleberg High School', 8041073929, 'Harrisonburg', 471, 'Kelly McDaniels', 1);
insert into school values(67, 'Deep Run Elementary School', 7038691316, 'Amherst', 428, 'Dave Chappelle', 1);
insert into school values(20, 'Huguenot High School', 8047261853, 'Fairfax', 643, 'Chris Dovi', 1);

insert into teacher values(1, 'Bob', 'Builder', 'BuilderBob2@fcps.edu', 8045437893, 'Richmond Elementary School', 23, 'Math', 'ES');
insert into teacher values(2, 'Peter', 'Griffin', 'GriffinPeter23@roan.edu', 7579314621, 'Plaza Middle School', 26, 'Science','MS');
insert into teacher values(4,	'Aaron', 'Lee',	'LeeAaron9@harrison.edu', 8023593842, 'Green Valley Elementary School', 54, 'CTE', 'ES');
insert into teacher values(5,	'Susan', 'Luis', 'luisSusan21@char.edu', 5054326592,	'Hydroflask High School', 29, 'Science', 'HS');
insert into teacher values(3, 'Sarah', 'West', 'WestSarah24@lynch.edu',  8042658911, 'Carytown High School', 35, 'Math', 'HS');
insert into teacher values(6,	'Linda', 'Mekonnen', 'lmekonnen@harrison.edu', 5058323592,	'Green Valley Elementary School', 54, 'Science', 'ES');
insert into teacher values(7, 'Patricia', 'Smith', 'smithp@roan.edu',  80423509321, 'Plaza Middle School', 26, 'Math', 'MS');
insert into teacher values(8,	'Mason', 'Griffin', 'masong@amherst.edu', 7036529751,	'Centreville High School', 47, 'Science', 'HS');
insert into teacher values(9, 'Anita', 'Dovi', 'dovianita@henr.edu',  5710573603, 'Liberty Middle School', 10, 'Math', 'MS');
insert into teacher values(10, 'Andrew', 'Yow', 'andyyow@rva.edu', 5958376037, 'Lincoln Elementary School', 30, 'Computer Skills', 'ES');
insert into teacher values(11, 'Lauryn', 'Hill', 'hilltop@staff.edu', 7095729172, 'Franklin Middle School', 25, 'CTE', 'MS');
insert into teacher values(12, 'Ariel', 'West', 'ariwest@harrison.edu', 5711135103, 'Littleberg High School', 58, 'Math', 'HS');
insert into teacher values(13, 'David', 'Cole', 'coled@amherst.edu', 6729571840, 'Deep Run Elementary School', 67, 'Computer Skills', 'ES');
insert into teacher values(14, 'Holly', 'Smith', 'smithh@harrison.edu', 8261952983, 'Green Valley Elementary School', 54, 'Science', 'ES');
insert into teacher values(15, 'Rebecca', 'Dovi', 'rebeccadovi@fcps.edu', 8048391234, 'Huguenot High School', 20, 'Math', 'HS');
