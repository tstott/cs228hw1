(package-initialize)


(custom-set-variables
 ;; custom-set-variables was added by Custom.
 ;; If you edit it by hand, you could mess it up, so be careful.
 ;; Your init file should contain only one such instance.
 ;; If there is more than one, they won't work right.
 '(blink-cursor-mode nil)
 '(compile-command "gcc ~/Dev/file-name.c -o file-name")
 '(custom-enabled-themes (quote (tango-dark)))
 '(font-use-system-font t)
 '(ido-mode (quote both) nil (ido))
 '(inhibit-startup-screen t)
 '(jde-compile-option-directory "/home/kakd/School/CS228/")
 '(jde-debugger (quote ("JDEbug")))
 '(jde-global-classpath
   (quote
    ("/home/kakd/School/CS228/" "/home/kakd/School/JAVA_CLASSES/" "/usr/share/java/junit.jar")))
 '(jde-import-excluded-classes
   (quote
    (("^bsh\\..*")
     ("^sun\\..*")
     ("^com\\.sun\\..*")
     (jde-import-current-package-p . t))))
 '(jde-jdk (quote ("1.6")))
 '(jde-jdk-registry (quote (("1.6" . "/usr/lib64/jvm/java-7-openjdk/"))))
 '(menu-bar-mode nil)
 '(package-archives
   (quote
    (("gnu" . "http://elpa.gnu.org/packages/")
     ("melpa" . "http://melpa.milkbox.net/packages/"))))
 '(scroll-bar-mode nil)
 '(tool-bar-mode nil)
 '(uniquify-buffer-name-style (quote post-forward) nil (uniquify)))
(custom-set-faces
 ;; custom-set-faces was added by Custom.
 ;; If you edit it by hand, you could mess it up, so be careful.
 ;; Your init file should contain only one such instance.
 ;; If there is more than one, they won't work right.
 '(default ((t (:inherit nil :stipple nil :background "#2e3436" :foreground "#eeeeec" :inverse-video nil :box nil :strike-through nil :overline nil :underline nil :slant normal :weight normal :height 120 :width normal :foundry "unknown" :family "Linux Libertine Mono O"))))
 '(cursor ((t (:background "chartreuse"))))
 '(success ((t (:foreground "spring green" :weight bold)))))

(require 'cl-lib)

(load (expand-file-name "~/quicklisp/slime-helper.el"))

(add-to-list 'load-path "~/.emacs.d/jdee-2.4.1/lisp")
(load "jde")


(require 'slime-autoloads)
(setq inferior-lisp-program "clisp")
;;(setq inferior-lisp-program "sbcl")
(setq slime-contribs '(slime-fancy)) 
(global-font-lock-mode 1)
(require 'hl-defined)
(add-hook 'emacs-lisp-mode-hook 'hdefd-highlight-mode 'APPEND)

(add-to-list 'auto-mode-alist '("\\.cl\\'" . lisp-mode))

(require 'lisp-mode)
(defun turn-on-slime-mode () (slime-mode 1))
(add-hook 'lisp-mode-hook 'turn-on-slime-mode)
(add-hook 'lisp-mode-hook (function (lambda ()
				      (show-paren-mode t))))

(load-file "/home/kakd/.emacs.d/cedet-1.1/common/cedet.el")

(require 'mic-paren)
(add-hook 'lisp-mode-hook
           (function (lambda ()
		       (rainbow-identifiers-mode 2))))


;;Emacs Octave for .m files.
(autoload 'octave-mode "octave-mod" nil t)
(setq auto-mode-alist
      (cons '("\\.m$" . octave-mode) auto-mode-alist))

;;Emacs Octave auto-complete.

(add-hook 'octave-mode-hook
          (lambda ()
            (abbrev-mode 1)
            (auto-fill-mode 1)
            (if (eq window-system 'x)
                (font-lock-mode 1))))

;;Email Setup stuff
;;(setenv "" "")
;;(setq rmail-primary-inbox-list '("po:tate")
;;      rmail-pop-password-required t)
;;Things to load at start


;;Initializes the bottom slime repl
;;(slime) 

