Проверку скриптов Java осуществляем из класса WantedTaskApplication

Решение по SQL(задача и структура таблиц ниже)

```
SELECT rg.name AS ФИО,
rg.birthDate AS Дата_рождения,
pd.contactRelationship AS Родственная_связь
FROM HPPersonDependant pd
JOIN HPPersonGeneric rg ON pd.HPRelatedPersonSysId = rg.sysId
WHERE pd.HPPersonGenericSysId = (SELECT sysId 
                                 FROM HPPersonGeneric 
                                 WHERE personId = 'test');
```

Скрипты на Java
Задача 1
Написать функцию, определяющую ближайшую дату отправки списка в страховую с
условием, что отправка осуществляется 1, 10 и 20 числа каждого месяца в 18:00. Если дата
отправки попадает на рабочий/праздничный день - то отправка осуществляется в
предыдущий рабочий день.
дата запроса == текущему времени.
Можно использовать функцию:
public getVacCheck(java.sql.Date modDate); - проверяет дату, является ли она рабочей. если
выходной - возвращает ближайший рабочий день следующий за выходными. Возвращает
переменную типа java.sql.Date

Задача 2
Написать функцию, возвращающую прописное написание стоимости (до тысяч 99 999.99).
Входной параметр переменная типа bigDecimal

Задача SQL
Первая - люди (хранятся персональные данные сотрудников и их родственников) -
HPPersonGeneric
столбцы
[sysId]
,[personId]
,[sysVersion]
,[photoFkSysId]
,[sysExtension]
,[salutation]
,[familyName]
,[givenName]
,[middleName]
,[name]
,[nameTranslationSysId]
,[altFamilyName]
,[altGivenName]
,[altMiddleName]
,[birthDate]
,[gender]
,[maritalStatus]
,[primaryLanguage]
,[citizenship]
,[residence]
,[ethnicity]
,[religion]
,[sysTenant]
,[createdBy]
,[creationTime]
,[sysChangeUser]
,[sysChangeTime]
,[sysParentId]
,[sysDateTo]
,[sysDateFrom]
Вторая - Родственные связи - HPPersonDependant
столбцы
[sysId]
,[sysVersion]
,[HPPersonGenericSysId]
,[HPRelatedPersonSysId]
,[attachmentFkSysId]
,[sysExtension]
,[contactRelationship]
,[id]
,[sysTenant]
,[createdBy]
,[creationTime]
,[sysChangeUser]
,[sysChangeTime]
,[sysParentId]
,[sysDateTo]
,[sysDateFrom]
Где:
● HPPersonGenericSysId- sysId сотрудника
● HPRelatedPersonSysId - sysId родственника
● contactRelationship- родственная связь

Задача написать запрос который выведет всех родственников (ФИО, дата рождение и
родственнная связь) для сотрудника с personId ='test'