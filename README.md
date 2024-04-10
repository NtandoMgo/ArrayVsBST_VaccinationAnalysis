# Vaccine Data Analysis with Array and BST

This repository contains Java applications for analyzing daily vaccination data for a list of countries using two different data structures: Array and Binary Search Tree (BST). The goal is to compare the performance of these data structures in terms of storage and retrieval speed.

## Dataset

The dataset (`vaccinations.csv`) consists of country names, dates, and vaccination numbers. It is a subset of data for the year 2022 obtained from Our World in Data. The dataset has been pre-processed and contains 9919 entries.

## Applications

### VaccineArrayApp

This application reads the dataset and stores the data items within a traditional array. It prompts the user to enter a date and a list of countries and then prints out the number of vaccinations for each country on that date.

#### Usage

java -cp bin VaccineArrayApp

## Example Output
Enter the date:
2022-02-17
Enter the list of countries (end with an empty line):
Norway
Suriname
South Namibia

Results:
Norway = 5803
Suriname = 134
South Namibia = Not Found

### VaccineBSTApp
This application performs the same tasks as VaccineArrayApp but uses a Binary Search Tree (BST) instead of an array to store the data.

### Usage
java -cp bin VaccineBSTApp

## Experiment
An experiment is conducted to compare the speed difference for searching between the BST and the traditional array. The applications are instrumented to count the number of comparison operations performed during the search.

### Running the Experiment
To run the experiment, execute both applications with the test data and redirect the output to different files.

java -cp bin VaccineArrayApp < testdata > array_output.txt
java -cp bin VaccineBSTApp < testdata > bst_output.txt

### Results
After running the experiment, analyze the output files to compare the performance of the two data structures.
