** Add your custom layer**

- The following 4 steps will add new custom layer with an example recipe called bbb-example, It will be installed in the new image and tested using the following

```
bitbake-layers add-layer <Path-of-poky-dir>/meta-mylayer/    # add layer
bitbake bbb-example                                          # bake your recipe
```
- Update conf/local.conf to include the new software in the final image, Add the following line.
```
IMAGE_INSTALL:append = " bbb-example"
```
- Run 
```
bitbake core-image-minimal
```


The following command runs the build task, which is the default task, on the foo_1.0.bb recipe file:

```
    bitbake -b foo_1.0.bb
```

The following command runs the clean task on the foo.bb recipe file:

```
    bitbake -b foo.bb -c clean
```

**To check file type**
```
terminal$   file bbb-example
bbb-example: ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib/ld-linux-x86-64.so.2, BuildID[sha1]=1e968f39c6becb90612b2152bd09c6ce5b33aef4, for GNU/Linux 3.2.0, with debug_info, not stripped
```

bitbake-layers show-recipes | grep python3-*
echo 'IMAGE_INSTALL_append = " dropbear gdb gdbserver strace evtest i2c-tools ethtool fbset memtester"' >> conf/local.conf



### Commands
```
bitbake -c do_configure bbb-example
bitbake -e bbb-example | grep ^WORKDIR=  # To serch for a variable
bitbake -c do_compile helloworld
bitbake -c do_fetch helloworld
bitbake -c do_unpack helloworld
bitbake -c do_compile helloworld
bitbake -c do_install helloworld
bitbake -c do_fetch helloworld
bitbake -c do_cleansstate bbb-example
bitbake -c do_cleansstate bbb-example
```


### Refs
https://docs.yoctoproject.org/2.7.3/bitbake-user-manual/bitbake-user-manual.html#bitbake-examples

