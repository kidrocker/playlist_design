#Design and folder structure
* Interfaces - Holds the interface classes that allow us 

* Models -

# Playlist class
The class takes a default constructor of the user object. 
It is sufficient to pass the user in the constructor as it is essential for the operation of the class and is not expected to change during the lifecycle of the class.

The class implements the interface ITrack that allows us to access and abstract the Track model in accordance to the solid principles.
The interface exposes methods that allow us to manipulate the playlist.

#### Local variables
1. mTrack - Mutable **set** of track. The set was  preffered due to the following reasons:
    * Sets ignore duplicate objects which means that the playlist cannot contain 2 identical tracks.
    * Sets share majority of the methods with lists.
2.     
