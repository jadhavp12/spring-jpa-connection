jpa cponnections in spring boot
here we have used flyway database apache derby
1. add jpa and apache derby dependency
2. create controller service and model class
3. map model class entity with @Entity and its primary key by @Id
4. Create interface XYZRepository and extend it with CrudRepository interface
5.provide generic parameteres(1. model entity class  ,primarykey datatype ) to CrudRepository interface which is extended in XYZRepository
6. create instance of XYZRepository interface and @Autowired it in service class
7. Call the default methods from CrudRepository like findById, findAll, save etc
8. you can create your own method in XYZRepository interface only rule is 1. method name should start with findBy(camelcase) and variable from your model class
example : findByName ,findByDescription etc 