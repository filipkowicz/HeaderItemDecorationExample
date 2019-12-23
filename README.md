[ ![Download](https://api.bintray.com/packages/filipkowicz/HeaderItemDecoration/header-item-decoration/images/download.svg) ](https://bintray.com/filipkowicz/HeaderItemDecoration/header-item-decoration/_latestVersion)

# HeaderItemDecorationExample
Simple Example how to use HeaderItemDecoration from gist https://gist.github.com/filipkowicz/1a769001fae407b8813ab4387c42fcbd


Note that this project is simple as possible and do not cover all best practices. Only goal of this project is to show how to 
integrate HeaderItemDecoration into your projects. 

All help welcomed 🙏 if you have any idea please clone and make PR 😊 

have fun and happy coding 😃 


## Import

```
compile 'com.filipkowicz.tools:header-item-decoration:0.8'
```

## How to use

```
import com.filipkowicz.headeritemdecorator.HeaderItemDecoration

...

recyclerView.addItemDecoration(HeaderItemDecoration(this,
                    shouldFadeOutHeader = true
                ) {
                // example check for header item
                    this@MainFragment.adapter.getItemViewType(it) == R.layout.header_layout
                })
```
