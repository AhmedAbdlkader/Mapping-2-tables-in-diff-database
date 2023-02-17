# Mapping-2-tables-in-diff-database
learning RestTemplate to communicate tow application + File upload and Download


In this repo , I put a project that containes
1- UserProject (8082) port
2- ProductProject (8083) port

every user can have many products 
and every product can have many users 

so to resolve this (to build the relation between 2 tables in diffrent databases)
I used RestTemplate to bring a Project object  from ProductProject 
and take from it the IdProject and the other fields and save it 
in assosiation table that i creat it in the UserProject


