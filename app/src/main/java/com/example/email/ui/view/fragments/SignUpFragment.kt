package com.example.email.ui.view.fragments

import android.os.Build
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.email.R
import com.example.email.data.model.MailModel
import com.example.email.databinding.FragmentSignUpBinding
import com.example.email.ui.view.activities.MainActivity
import com.example.email.ui.viewmodel.MailViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar


class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    private lateinit var mailViewModel: MailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(inflater, container, false)

        bindViews()
        togglePassword()

        return binding.root
    }

    private fun bindViews() {
        binding.btnSignUp.setOnClickListener {
            val mailText = binding.emailAddress.text.toString().trim()
            val passText = binding.password.text.toString().trim()
            setMailSave()
        }
    }

    private fun setMailSave() {
        mailViewModel = (activity as MainActivity).mailViewModel
        val mailText = binding.emailAddress.text.toString().trim()
        val passText = binding.password.text.toString().trim()
        val mailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        when {
            mailText.isEmpty() ->{
                binding.emailAddress.requestFocus()
                binding.emailAddress.error = "لطفا فیلد مورد نظر را پر نمایید"
            }
            !mailText.matches(mailPattern.toRegex()) ->{
                binding.emailAddress.requestFocus()
                binding.emailAddress.error = "لطفا از ورودی معتبر استفاده کنید"
            }

            passText.isEmpty() ->{
                binding.password.requestFocus()
                binding.password.error = "لطفا فیلد مورد نظر را پر نمایید"
            }
            passText.length < 8 -> {
                binding.password.requestFocus()
                binding.password.error = "رمز عبور وارد شده نباید کم تر از 8 کاراکتر باشد"
            }
            else ->{
                //Add Mail
                val mail = MailModel(0, mailText, passText)
                mailViewModel.addMail(mail)

                //Show Message
                val snackbar = Snackbar.make(binding.root, "ثبت نام موفقیت آمیز بود", Snackbar.LENGTH_LONG)
                snackbar.duration = 4000
                snackbar.view.layoutDirection = View.LAYOUT_DIRECTION_RTL
                snackbar.show()

                //Action to HomeFragment
                findNavController().navigate(R.id.action_signUpFragment_to_homeFragment)
            }

        }
    }


    private fun togglePassword() {
        val pass = binding.password

        val show: MaterialButton = binding.showButton
        val hide: MaterialButton = binding.hideButton

        show.setOnClickListener {
            show.visibility = View.INVISIBLE
            hide.visibility = View.VISIBLE
            pass.transformationMethod = HideReturnsTransformationMethod.getInstance()
        }

        hide.setOnClickListener {
            hide.visibility = View.INVISIBLE
            show.visibility = View.VISIBLE
            pass.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }


}