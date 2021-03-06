# Java, многопоточное программирование.
# Инструкция по запуску
#### (Постановка задачи находится во второй половине файла)
При запуске метода main программа ожидает ввода значения в консоли:
* "0" - пропуск загрузки файла
* "1" - загрузка тестовых данных с платежами, расположенных в файле startBalance.txt (находится в корневом каталоге проекта)
* Указание полного пути к файлу с платежами, который будет считан при запуске программы

Окончанием работы программы служит ввод команды quit в консоли

Курсы валют относительно USD для бонусного задания хранятся в HashMap usdCurrency и заполняются при запуске программы в методе getUsdCurrency() <br>

При вводе с консоли операции по изменению баланса введенная строка проверятся на наличие двух слов (разделенных пробелом) и на число (денежная сумма) во втором слове. <br>
Денежные суммы хранятся в формате BigDecimal <br>

При чтении стартового баланса в файле осуществляются проверки FileNotFoundException и IOException

# Постановка задачи
## Общее описание
Написать приложение для учета платежей. <br>
Каждый платеж описывается суммой и валютой. <br>
Раз в минуту программа должна выводить в консоль текущий баланс по всем валютам. <br>
Ввод данных выполняется через консоль.  <br>
Также должна быть предусмотрена возможность указать текстовый файл с платежами, который будет считан при запуске программы.
### Примеры вводимых данных:
* USD 1000
* HKD 100
* USD -100
* RMB 2000
* HKD 200
### При указанных данных программа должна отобразить баланс:
* USD 900
* RMB 2000
* HKD 300
### Детальные требования
В файле, который может быть указан при запуске, будут содержаться данные о платежах в том же формате: код валюты и сумма через пробел, по одному платежу в каждой строке.<br>
Баланс выводится один раз в минуту. Если для какой-то валюты текущий баланс равен 0, соответствующая ей строка не выводится.<br>
Программа завершается, если пользователь вводит команду quit и нажимает Enter.<br>
Пользователь может вводить неверные данные; эту ситуацию разработчик должен обработать на свое усмотрение (в readme.txt следует описать, как именно программа обрабатывает ошибки).<br>
Исходные коды программы должны быть размещены в Git: GitHub, BitBucket. Для сборки и запуска приложения рекомендуется использовать Maven. В описании программы (readme.txt) должна присутствовать инструкция по запуску. <br>
## Бонус
Дополнительно можно реализовать возможность указать курсы валют относительно USD и выводить баланс в USD для каждой из валют:
* USD 900
* RMB 2000 (USD 314.60)
* HKD 300 (USD 38.62)


1. При чтении файла со стартовым балансом обрабатываются ошибки FileNotFoundException и IOException <br>
2. При вводе строки операции со счетом проверяется чтобы было два слова, разделенных одним пробелом. Также во втором слове должны быть только цифры без букв (сумма)
