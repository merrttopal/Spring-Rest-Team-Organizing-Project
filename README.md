
# Carpet Field Competition Team Organizing Project

This project aims to organize teams by selecting footballers to join teams A and B for a football match.

## How does it work?

The project is a REST API application developed with Java Spring Boot. h2 is used as the database. The project offers the following functionalities:

-Subscribing to the system: The footballer registers to the system by entering first name, last name, e-mail, password and age. There must be a rule of at least 18 years of age and above when registering. At the end of this process, if the membership is successful, the "fid" id is given to the footballer. If the player has been a member before, he should receive a warning.

-Joining the team: With the "fid" assigned to him/her, the footballer indicates which team he/she will be a member of and joins that team. Teams are available as "A" and "B" teams. The soccer player must log in to the system before applying for a team. A soccer player can be a member of one team at the same time, if he wants to join another team, the application should give a warning that he has already joined a team.

-Creating teams: The system should create the teams after the applications for teams A and B. Each team should consist of 6 people. Teams should be formed in order of age from the youngest to the oldest.

-Creation of reserves: For each team, if there is an extra application, there should be a reserve list. The reserve list should consist of 3 people who are not assigned to the main team, again in order of age from youngest to oldest.

### Security
This project uses Google Tink library to encrypt the passwords of the users who register to the system. Google Tink is a multi-language, cross-platform cryptographic library that provides secure and easy-to-use APIs for various cryptographic tasks. The passwords are encrypted with AES-GCM algorithm and stored in the database. The encryption keys are managed by Tink’s key management system. This way, the passwords are protected from unauthorized access and tampering.

## Installation

You can download the source code of the project via git:

git clone https://github.com/merrttopal/Team-Organizing-Project.git

Since the project is Maven based, it will automatically download the dependencies.

The project uses the h2 database. Therefore make sure you have h2 installed. In the project's application.properties file you can find the necessary information to connect to the database.

## Usage

You can use Postman to test this project. Postman requests are located in the project folder under the postman folder. You can download the postman folder and import it in the Postman application. Then you can test the functionality of the project by running the requests.
