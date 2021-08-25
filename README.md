# News_Portal
####  A rest REST API for querying and retrieving scoped news and information.
#### By **Rabecca Nzau**
## Description
A rest REST API for querying and retrieving scoped news and information.
## Setup/Installation Requirements
* git clone``` https://github.com/Becka7/models.News-portal.git```
* cd your/path/to/Forest-tracker
* open with editor of choice

##### DATABASE SETUP PSQL
```
 CREATE DATABASE news_portal;

 CREATE TABLE users(id serial PRIMARY KEY,name text,role varchar,department_id int);
 
 CREATE TABLE departments(id serial PRIMARY KEY,name varchar,description varchar,employees int);
 
 CREATE TABLE news(id serial PRIMARY KEY,text varchar,department varchar);

```

#####  TEST DATABASE SETUP
```CREATE DATABASE news_portal_test WITH TEMPLATE news_portal```

## Known Bugs
There are no known bugs at the moment
## Technologies Used
Java

Spark

PostgreSQL

Handlebars

Markdown

CSS

Bootstrap


## Support and contact details
In case of any concerns you can reach me at ;

beckyj1601@gmail.com

https://github.com/Becka7?tab=repositories
### License
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
MIT License

Copyright (c) [2021] **Rabecca Nzau**