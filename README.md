# AppPeeker: Peeking At What Methods Are On `android.app.Application`

This sample app does two things:

1. Shows a alphabetized list of all methods declared on
`android.app.Application`, which will include those that
are marked with `@hide` in the AOSP.

2. Reports whether the undocumented `instantiateActivity()`
method was called.

On a Pixel 2, you should see `instantiateActivity()` appear
in the list, and a message at the top will say that the
method was called. On a Nexus 5X &mdash; even one running
Android 8.1 DP1 &mdash; you should not see
`instantiateActivity()` appear
in the list, and a message at the top will say that the
method was not called.

## Notes

- The app's `minSdkVersion` is 21. You are welcome to fork
the repo and support older devices if you wish, but the author
of the app will question your life choices.

- `minifyEnabled` is set to `false`, as the author didn't feel
like fussing with ProGuard for a scrap app like this one.
If you fork the repo and want to enable ProGuard, note that
the `instantiateActivity()` method will get removed by
default, as nothing appears to reference it, so add that to
your ProGuard rules.

## License
The code in this project is licensed under the Apache
Software License 2.0, per the terms of the included LICENSE
file.

## Questions
If you have questions about this app, bear in mind that the
author probably does not know the answer. But, feel free
to file an issue, which will be used as an ersatz discussion
board for this project.

## Release Notes
- v1.0.0: initial release, already at 1.0.0, because YOLO

## Who Do We Blame For the Existence of This?
<a href="http://commonsware.com">![CommonsWare](http://commonsware.com/images/logo.png)</a>

