# Bright Android Technical Test 2023

This project forms the basis for the technical task for Android developer applicants.
Please carefully read these instructions before beginning the task.

* The task should no more than 6 hours to complete
* You are welcome to consult the internet, documentation or code you have written to help you
* We encourage you to use tools like the debugger and Layout Inspector to diagnose issues.

*We will assess you on:*

* Understanding of best practices in Android development
* Clear code organisation
* The size and message of git commits

*We are less concerned with:*

* UI styling / animation etc.

## The Starter Project

This project uses the JSON placeholder API to display a list of posts. 
The list includes the title of each post and an
excerpt from each post's body. Tapping a post should open a post details screen that
displays the title and complete body of the post.

The code of the starting application is *deliberately poor* and contains
several examples of *bad practice* according to Modern Android Development.
This is to give you the opportunity to demonstrate how you would tackle improving legacy
code.

## Your task:

1. Survey the code in this project and leave comments under everything you notice 
that needs to be fixed or improved.
2. Pick 2 or 3 of these issues and implement fixes / improvements.
    - Feel free to refactor and change the architecture of the code
    - You can add 3rd party libraries, but shouldn't need to (be prepared to explain your choices)
3. Implement a simple post detail screen 
4. We would like to see
      a) an example of a *Unit* test
      b) an example of an *Instrumented test*
5. Add additional comments (either inline or in a separate file) to outline what further improvements
you might make if you had a few days to work on the code.

## The API

The app uses the following endpoints from the [JSON
placeholder](https://jsonplaceholder.typicode.com) API:

    GET https://jsonplaceholder.typicode.com/posts/

    GET https://jsonplaceholder.typicode.com/posts/{POST_ID}/

    GET https://jsonplaceholder.typicode.com/posts/{POST_ID}/comments/

## Submitting your work

-   You should submit the above as either a compressed git repository (zip file)
    or a link to your repository on github or similar hosting service.
    Please commit regularly as you carry out the task and
    keep the commit history in tact.

## Interview pairing tasks

In your interview we will ask you more about your process in completing the above tasks.

There will also be a short exercise where you will be paired with one of our Android team member
and given a task to develop this project further. You will have full access to internet
resources to help you.