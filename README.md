# Minecraft Hats
A Minecraft Spigot plugin to add hats to Minecraft
using the new (1.19.4+) display entities.
This is just a demo.
It's not supposed to be used in a production server,
as the user interface (i.e. commands) are not made for such use.

✏️ Feel free to use this project as inspiration for your own projects,
or maybe even use the code as a library.
Be sure to follow the license though ;).

## Features
The plugin features a framework to add head-tracked entities to a player.
These entities (the `Hat` interface), or group of entities, really,
are static by default.
They just follow the position of the player, and its head movements.

A hat is made of a set of hat components (`HatComponent`).
Normal hat components are static by default,
but they can be extended to support additional state.

There's currently one example of an actual hat: the propeller cap.
It's a normal cap with a spinning propeller on top.
When executing `/liftoff`, the propellers start to spin rapidly,
and the player starts to lift off.


## Why?
I don't know, really.
It's just a hobby project of mine,
as I think propeller caps are very funny.
I think it's a nice project to work on my skills,
and have a little fun :).


## Demo
[![Demo video](https://img.youtube.com/vi/dzVtftEQqdc/0.jpg)](https://www.youtube.com/watch?v=dzVtftEQqdc)
