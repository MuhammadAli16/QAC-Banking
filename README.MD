Run the following:

From the directory that contains the POM file:

mvn clean package docker:build

Then run:

docker run --name bank-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=movie -e MYSQL_USER=bank_user -e MYSQL_PASSWORD=bank_pass -d mysql:5.6

docker logs bank-mysql (ensure mysql server is up)

docker run -p 8080:8080 --name bank-app --link bank-mysql:mysql -d qabank/movie

docker logs bank-app (ensure app is up by accessing http://localhost:8080)
