# Quick build for qemu

```
sudo apt-get update      
```
#### Install requirements
```
sudo apt install gawk wget git diffstat unzip texinfo gcc build-essential chrpath socat cpio python3 python3-pip python3-pexpect xz-utils debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa libsdl1.2-dev pylint3 xterm python3-subunit mesa-common-dev zstd liblz4-tool
```
#### Clone poky & sorce environment
```
mkdir yocto_tutorial
cd yocto_tutorial
git clone git://git.yoctoproject.org/poky -b kirkstone
cd poky
source oe-init-build-env qemu-build  
```
now we need to 
1. change the build target to qemu
2. create our own sources folder for better file organization ( optional )
3. change the download folder sstate-cache folder to the one created at step 2, all changes are available conf/local.comf file, make sure to grep only changes that you need.
4. build the minimal image `bitbake core-image-minimal`
5. test `runqemu qemux86-64`

## Add your custom layer

- The following 4 steps will add new custom layer with an example recipe called bbb-example, It will be installed in the new image and tested using the following

```
bitbake-layers add-layer <Path-of-poky-dir>/meta-mylayer/    #1. add layer
bitbake bbb-example                                          #2. bake your recipe
```
- 3. Update conf/local.conf to include the new software in the final image, Add the following line.
```
IMAGE_INSTALL:append = " bbb-example"
```
- 4. Run 
```
bitbake core-image-minimal
```







### Commands Toolkit
```
devtool add help
devtool edit-recipe recipe-name
devtool  add link.git
bitbake recipe-name -c devshell # to open a devshell
ls -alh imag.tar.bx # show image size

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
bitbake-layers show-recipes | grep python3-*        # show recipes
```
### Create Layer
```
bitbake-layers show-layers
bitbake-layers show-recipes 'linux-*'
bitbake-layers show-overlayed
bitbake-layers create-layer
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
bbb-example: ELF 64-bit LSB pie executable, x86-64...
```


### Refs
Useful Repo: https://github.com/Munawar-git/YoctoTutorials/tree/master

Bitbake Manual: https://docs.yoctoproject.org/2.7.3/bitbake-user-manual/bitbake-user-manual.html#bitbake-examples

