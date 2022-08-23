mydata <- iris[,-5]
my_centers <- iris[c(40,80,120),-5]
kmeans(mydata,my_centers)