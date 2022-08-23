pima <-read.csv("D:\\Study and Documents\\MPhil\\Slides-Lecture\\DM\\assignment_2016\\KNN\\pima_n.csv")
pima.trainingClass <- pima[,9] #class column from dataset
pima <- pima[,-9] #remove class column from training dataset
pima.testing <- read.csv("D:\\Study and Documents\\MPhil\\Slides-Lecture\\DM\\assignment_2016\\KNN\\instances_n.csv") 
require(class)
m1 <- knn(train = pima, test = pima.testing, cl = pima.trainingClass, k=9)
