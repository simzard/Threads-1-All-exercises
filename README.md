# Threads-1-All-exercises
Solutions to all the exercises in Threads-1

## Textual answers to the questions in the exercises:

##Exercise 2 (Race condition)

**Question**: Explain what happens?

**Answer**: What happens is that since the Even.next() method is NOT atomic, part of the 
    increments can occur in both threads, whhich means that when one thread
    is done with its call to Even.next() another thread might be incrementing
    its value at the same time. This could result in various increments from 0 
    up till 4 before the next test is done! this is also the cause of uneven numbers.

**Question**: How common is the problem?

**Answer**: I would say that it is very common. In every multithreaded application, we must remember to protect our data with synchronization. :)

##Exercise 3 (Blocking the GUI-thread)

**Question**: What is the obvious problem with this solution?

**Answer**: The obvious problem with this solution (program) is that
        when you have pushed the start button, the GUI freezes, because the
        event queue is blocked by the code in the button

##Exercise 5 (Race condition)
**Question**: Identify where it goes wrong :

**Answer**: It goes wrong in the BankAccountUnsynchronized class:
        in the *withdraw()* and *deposit()* methods. They are not 
        synchronized and thus will be victims to a race condition in this case.

**Question**: What should the closing balance be?

**Answer**:   It should be 0, since we withdraw and deposit the same amount!
            
**Experiment**: increasing the number of threads increse the imprecision
                   however - it seams that we get more OK values printed out
                   but still that IS totally random because of the OS.
                   
##Exercise 6 (Blocking the GUI thread)

**Question**: What are the obvious problems (at least two) of the solution?

**Answer**: The two most obvious problems are that **1)** the GUI freezes, when you press the button
                              and             **2)** the display is only updated in the end
                   
                   
  (I've implemented both with normal threads and with SwingWorker two solutions that both reset the counter whenever you click the button - even if is counting down...)
                   
