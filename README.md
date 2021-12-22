Домашнее задание к занятию «Наследование и расширяемость систем. Проблемы наследования»

В качестве результата пришлите ссылки на ваши GitHub-проекты в личном кабинете студента на сайте netology.ru.

Все задачи этого занятия можно делать в одном репозитории.

Важно: если у вас что-то не получилось, то оформляйте Issue по установленным правилам.

Вы можете делать все задачи этого занятия в одном репозитории (если делаете их в разных ветках).

Напоминалку по некоторым теоретическим моментам в джаве вы можете найти здесь.
Как сдавать задачи

    Ознакомьтесь с особенностями Lombok при использовании наследования
    Ознакомьтесь с доп.материалами о static и reflection
    Инициализируйте на своём компьютере пустой Git-репозиторий
    Добавьте в него готовый файл .gitignore
    Добавьте в этот же каталог необходимые файлы (pom.xml)
    Сделайте ветки для первой задачи (после того, как сделаете первую задачу, на её основе создайте ветку для второй задачи)
    Создайте публичный репозиторий на GitHub и свяжите свой локальный репозиторий с удалённым
    Сделайте пуш (удостоверьтесь, что ваш код и обе ветки появились на GitHub)
    Ссылку на ваш проект отправьте в личном кабинете на сайте netology.ru
    Задачи, отмеченные как необязательные, можно не сдавать, это не повлияет на получение зачета

Задача №1 - "Менеджер Товаров"

На основании проекта из лекции необходимо реализовать менеджер товаров, который умеет:

    Добавлять товары в репозиторий
    Искать товары

Что нужно сделать:

    Разработайте базовый класс Product, содержащий id, название, стоимость
    Разработать два унаследованных от Product класса: Book (с полями название* и автор) и Smartphone (с полями название* и производитель)
    Разработайте репозиторий, позволяющий сохранять Product'ы, получать все сохранённые Product'ы и удалять по id. Для этого репозиторий будет хранить у себя поле с типом Product[] (массив товаров).
    Разработайте менеджера, который умеет добавлять Product'ы в репозиторий и осуществлять поиск по ним. Для этого вам нужно создать класс, конструктор которого будет принимать параметром репозиторий, а также с методом publiс void add(Product product) и методом поиска (см. ниже).

Примечание*: надеемся, вы догадались, что название итак уже есть в классе Product и будет наследовано от него в классах Book и Smartphone
Как осуществлять поиск

У менеджера должен быть метод searchBy(String text), который возвращает массив найденных товаров

public class ProductManager {
// добавьте необходимые поля, конструкторы и методы

public Product[] searchBy(String text) {
// ваш код
}

public boolean matches(Product product, String search) {
if (product instanceof Book) { // если в параметре product лежит объект класса Book
Book book = (Book) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
if (book.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
return true;
}
if (book.getTitle().contains(search)) {
return true;
}
return false;
}
...
return false;
}
}

Менеджер при переборе всех продуктов, хранящихся в массиве (или в репозитории, если вы в предыдущих ДЗ сделали репозиторий)*, должен для каждого продукта вызывать определённый в классе менеджера же метод matches, который проверяет, соответствует ли продукт поисковому запросу.

Примечание*: если вы сделали репозиторий, то пусть менеджер забирает из репозитория все товары и сам уже по ним ищет.

При проверке на соответствие запросу книги мы проверяем по полям названия и автора, для смартфона по полям названия и производителя.
Подсказка

Требования к проекту:

    Создайте ветку (не делайте ДЗ в master!)
    Подключите плагин Surefire так, чтобы сборка падала в случае отсутсвия тестов
    Подключите плагин JaCoCo в режиме генерации отчётов (обрушать сборку по покрытию не нужно)
    Реализуйте нужные классы и методы
    Напишите автотесты на метод поиска (только на метод поиска в менеджере), добившись 100% покрытия по branch'ам* (вспомните, что мы говорили про тестирование методов, возвращающих набор значений)
    Подключите CI на базе Github Actions и выложите всё на Github

Примечание*: использовать Mockito или нет, мы оставляем на ваше усмотрение.

Итого: у вас должен быть репозиторий на GitHub, в котором расположен ваш Java-код в ветке (в master должен быть только pom.xml).
Задача №2 - "Менеджер Товаров" (Rich Model)*

Важно: это необязательная задача. Её (не)выполнение не влияет на получение зачёта по ДЗ.
Легенда

Достаточно часто объекты, моделирующие предметную область, называют моделями. Достаточно часто модели делают "глупыми", т.е. не содержащими никакой логики.

Но есть и другой подход, который позволяет делать "умные" или "богатые" модели (Rich Model), которые могут уже содержать определённую логику.

Что нужно сделать:

    Создайте новую ветку на базе ветки, в которой вы решали первую задачу
    Реализуйте в классе Product метод public boolean matches(String search), который определяет, подходит ли продукт поисковому запросу исходя из названия
    Переопределите этот метод в дочерних классах, чтобы они сначала вызывали родительский метод и только если родительский метод вернул false, тогда проводили доп.проверки (Book - по автору, Smartphone - по производителю).
    Уберите из менеджера все instanceof и метод matches, т.к. теперь у вас "умные" модели и благодаря переопределению методов вам этот код больше не нужен
    Зато теперь вам нужны unit-тесты на методы ваших умных моделей (напишите их)
    Удостоверьтесь, что ранее написанные тесты на менеджера (из решения задачи 1) проходят

Итого: у вас должен быть репозиторий на GitHub, в котором расположен ваш Java-код в двух ветках (в master должен быть только pom.xml).
Подсказка №1
Подсказка №2 (про оператор ||)